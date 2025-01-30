package com.it.jiangxin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.config.TreeNode;
import com.it.jiangxin.config.exception.BizException;
import com.it.jiangxin.entity.YmlEntity;
import com.it.jiangxin.entity.vo.YmlQo;
import com.it.jiangxin.mapper.YmlMapper;
import com.it.jiangxin.service.YmlService;
import com.it.jiangxin.util.BoolUtils;
import com.it.jiangxin.util.YmlUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Tag(name = "系统用户")
@RestController
@RequestMapping("/api/YmlController")
@Slf4j
public class YmlController {
    @Resource
    private YmlService ymlService;
    @Resource
    private YmlMapper ymlMapper;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Integer> create(@RequestBody YmlEntity entity) {
        ymlService.save(entity);
        Map<String, Object> map = YmlUtils.toMap(entity.getValue());
        System.out.println(map);
        saveYmlEntity(map, entity.getId());
        return ApiResult.success(entity.getId());
    }


    public void saveYmlEntity(Object data, Integer parentId) {
        if (data instanceof String) {
            String str = (String) data;
            YmlEntity entity = new YmlEntity();
            entity.setValue(str);
            entity.setAsk(str);
            entity.setParentId(parentId);
            ymlService.saveOrUpdate(entity);
            return;
        }
        if (data instanceof Map) {
            Map<String, Object> map = (Map) data;
            for (String key : map.keySet()) {
                YmlEntity entity = new YmlEntity();
                entity.setValue(key);
                entity.setAsk(key);
                entity.setParentId(parentId);
                ymlService.saveOrUpdate(entity);
                saveYmlEntity(map.get(key), entity.getId());
            }
            return;
        }
        throw new BizException("不能到达此处");
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<YmlEntity>> getPage(Page<YmlEntity> page, YmlEntity entity) {
        page = ymlService.lambdaQuery()
                .eq(BoolUtils.toBool(entity.getId()), YmlEntity::getId, entity.getId())
                .like(BoolUtils.toBool(entity.getAsk()), YmlEntity::getAsk, entity.getAsk())
                .eq(Objects.nonNull(entity.getParentId()), YmlEntity::getParentId, entity.getParentId())
                .page(page);
        return ApiResult.success(page);
    }

    @Operation(summary = "getParent")
    @GetMapping("/getParent")
    public ApiResult<List<YmlEntity>> getParent(YmlQo entity) {
        List<YmlEntity> list = ymlMapper.getParent(entity);
        return ApiResult.success(TreeNode.getTree(list));
    }

    @Operation(summary = "getChildren")
    @GetMapping("/getChildren")
    public ApiResult<List<YmlEntity>> getChildren(YmlQo entity) {
        List<YmlEntity> list = ymlMapper.getChildren(entity);
        return ApiResult.success(TreeNode.getTree(list));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody YmlEntity entity) {
        return ApiResult.success(ymlService.updateById(entity));
    }

    @Operation(summary = "根据删除修改")
    @GetMapping("/deleteById")
    public ApiResult<Boolean> deleteById(Integer id) {
        return ApiResult.success(ymlService.removeById(id));
    }
}
