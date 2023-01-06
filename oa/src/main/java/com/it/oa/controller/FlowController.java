package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.entity.FlowConditionEntity;
import com.it.oa.entity.FlowEntity;
import com.it.oa.entity.FlowNodeEntity;
import com.it.oa.entity.FormItemEntity;
import com.it.oa.service.FlowConditionService;
import com.it.oa.service.FlowNodeService;
import com.it.oa.service.FlowService;
import com.it.oa.service.FormItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.it.oa.config.constant.FlowStatus.UN_ENABLE;


@Api(tags = "人事管理/办公审批/审批设置")
@RestController
@RequestMapping("/api/flow")
@Slf4j
public class FlowController {

    @Resource
    private FlowService flowService;
    @Resource
    private FormItemService formItemService;

    @Resource
    private FlowNodeService flowNodeService;

    @Resource
    private FlowConditionService flowConditionService;

    @ApiOperation(value = "发布")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody FlowEntity flowEntity) {
        flowEntity.setStatus(UN_ENABLE);
        flowService.save(flowEntity);
        flowEntity.getFormItemList().forEach(vo -> vo.setFlowId(flowEntity.getId()));
        formItemService.saveBatch(flowEntity.getFormItemList());

        // 保存流程 1-1
        saveFlowItemTree(flowEntity.getId(), null, flowEntity.getFlowNodeTree());

        return ApiResult.success();
    }

    // 保存节点 2-1
    public void saveFlowItemTree(Integer flowId, Integer parentId, List<FlowNodeEntity> flowItemTree) {
        if (flowItemTree.isEmpty()) {
            return;
        }
        flowItemTree.forEach(vo -> {
            vo.setFlowId(flowId);
            vo.setParentId(parentId);
        });
        flowNodeService.saveBatch(flowItemTree);
        for (FlowNodeEntity entity : flowItemTree) {
            saveFlowItemTree(flowId, entity.getFlowId(), flowItemTree);
        }

        // 节点条件 list -- 3-1
        for (FlowNodeEntity entity : flowItemTree) {
            entity.getFlowConditionList().forEach(vo -> vo.setFlowNodeId(entity.getId()));
            flowConditionService.saveBatch(entity.getFlowConditionList());
        }
    }

    @ApiOperation(value = "查询全部审批")
    @GetMapping("/getAll")
    public ApiResult<List<FlowEntity>> getAll() {
        return ApiResult.success(flowService.list());
    }

    @ApiOperation(value = "分页查询树形数据")
    @GetMapping("/getFlowTree")
    public ApiResult<Page<FlowEntity>> getFlowTree(Page<FlowEntity> page, FlowEntity flowEntity) {
        page = flowService.page(page, new QueryWrapper<>(flowEntity));
        for (FlowEntity entity : page.getRecords()) {
            List<FormItemEntity> formItemList = formItemService.lambdaQuery().eq(FormItemEntity::getFlowId, entity.getId()).orderByAsc(FormItemEntity::getSort).list();
            flowEntity.setFormItemList(formItemList);

            List<FlowNodeEntity> flowNodeTree = getFlowNodeTree(entity.getId());
            flowEntity.setFlowNodeTree(flowNodeTree);
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "获取流程树形数据")
    @GetMapping("/getFlowTreeById")
    public FlowEntity getFlowTreeById(Integer id) {
        FlowEntity flowEntity = flowService.getById(id);
        List<FormItemEntity> formItemList = formItemService.lambdaQuery().eq(FormItemEntity::getFlowId, id).orderByAsc(FormItemEntity::getSort).list();
        flowEntity.setFormItemList(formItemList);

        List<FlowNodeEntity> flowNodeTree = getFlowNodeTree(id);
        flowEntity.setFlowNodeTree(flowNodeTree);

        return flowEntity;
    }

    public List<FlowNodeEntity> getFlowNodeTree(Integer flowId) {
        List<FlowNodeEntity> all = flowNodeService.lambdaQuery().eq(FlowNodeEntity::getFlowId, flowId).orderByAsc(FlowNodeEntity::getParentId, FlowNodeEntity::getSort).list();
        List<FlowNodeEntity> tree = new ArrayList<>();
        for (FlowNodeEntity flowNodeEntity : all) {
            if (flowNodeEntity.getParentId() == null) {
                tree.add(flowNodeEntity);
            }
            for (FlowNodeEntity entity1 : all) {
                if (Objects.equals(flowNodeEntity.getId(), entity1.getParentId())) {
                    flowNodeEntity.getChildren().add(entity1);
                }
            }
        }
        for (FlowNodeEntity flowNodeEntity : all) {
            List<FlowConditionEntity> list = flowConditionService.lambdaQuery().eq(FlowConditionEntity::getFlowNodeId, flowNodeEntity.getId()).list();
            flowNodeEntity.setFlowConditionList(list);
        }
        return tree;
    }


    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody FlowEntity flowEntity) {
        return ApiResult.success(flowService.updateById(flowEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(flowService.removeById(para.getId()));
    }

}