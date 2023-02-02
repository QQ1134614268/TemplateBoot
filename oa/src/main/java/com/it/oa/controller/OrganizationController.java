package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.config.ConstConf;
import com.it.oa.config.exception.OaGlobalException;
import com.it.oa.controller.para.*;
import com.it.oa.entity.InviteEntity;
import com.it.oa.entity.OrganizationEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.entity.UserOrgEntity;
import com.it.oa.service.InviteService;
import com.it.oa.service.OrganizationService;
import com.it.oa.service.UserOrgService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "人事管理/组织架构")
@RestController
@RequestMapping("/api/organization")
@Slf4j
public class OrganizationController {
    @Resource
    private OrganizationService organizationService;
    @Resource
    private UserService userService;
    @Resource
    private UserOrgService userOrgService;

    @Resource
    private InviteService inviteService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody OrganizationEntity organizationEntity) {
        return ApiResult.success(organizationService.save(organizationEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<OrganizationEntity>> getPage(Page<OrganizationEntity> page, OrganizationEntity organizationEntity) {
        return ApiResult.success(organizationService.page(page, new QueryWrapper<>(organizationEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody OrganizationEntity organizationEntity) {
        // 是否部门负责人
        return ApiResult.success(organizationService.updateById(organizationEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(organizationService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(organizationService.removeByIds(para.getIds()));
    }

    @ApiOperation(value = "根据组织id,获取下级组织和员工")
    @PostMapping("/getOrgAndUser")
    public ApiResult<List<OrganizationDTO>> getOrgAndUser(@RequestParam Integer id) {
        List<UserEntity> user = userService.lambdaQuery().eq(UserEntity::getOrgId, id).list();
        List<OrganizationEntity> organizationEntityList = organizationService.lambdaQuery().eq(OrganizationEntity::getParentId, id).list();
        List<OrganizationDTO> ret = new ArrayList<>();
        user.forEach(vo -> {
            OrganizationDTO dto = new OrganizationDTO();
            dto.setUserId(vo.getId());
            dto.setName(vo.getStaffName());
            ret.add(dto);
        });
        organizationEntityList.forEach(vo -> {
            OrganizationDTO dto = new OrganizationDTO();
            dto.setUserId(vo.getId());
            dto.setName(vo.getOrgName());
            ret.add(dto);
        });
        return ApiResult.success(ret);
    }


    @ApiOperation(value = "获取部门树形数据")
    @PostMapping("/getOrgTree")
    public ApiResult<List<DepartmentVo2>> getOrgTree() {
        List<OrganizationEntity> all = organizationService.lambdaQuery()
                .orderByAsc(OrganizationEntity::getParentId)
                .orderByAsc(OrganizationEntity::getOrgOrder)
                .list();

        List<DepartmentVo2> org = all.stream().map(entity -> {
            DepartmentVo2 vo = new DepartmentVo2();
            vo.setId(entity.getId());
            vo.setParentId(entity.getParentId());
            vo.setLeaderId(entity.getLeaderId());
            vo.setDescription(entity.getDescription());
            vo.setIsOrg(true);
            vo.setOrgName(entity.getOrgName());
            return vo;
        }).collect(Collectors.toList());

        List<DepartmentVo2> tree = new ArrayList<>();
        for (DepartmentVo2 entity : org) {
            if (entity.getParentId() == null) {
                tree.add(entity);
            }
            for (DepartmentVo2 entity1 : org) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
        }
        return ApiResult.success(tree);
    }

    @ApiOperation(value = "获取/成员")
    @GetMapping("/getMember")
    public ApiResult<List<DepartmentVo2>> getMember(Integer id) {

        return ApiResult.success();
    }

    @ApiOperation(value = "编辑/成员")
    @PostMapping("/updateMember")
    public ApiResult<List<DepartmentVo2>> updateMember(@RequestBody MemberUo uo) {
        // todo 管理范围
        if (toBool(uo.getOrgIds())) {
            throw new OaGlobalException("请设置主部门");
        }
        userService.lambdaUpdate().eq(UserEntity::getId, uo.getId())
                .set(UserEntity::getStaffName, uo.getStaffName())
                .set(UserEntity::getPhone, uo.getPhone())
                .set(UserEntity::getSex, uo.getSex())
                // .set(UserEntity::getOrgId, )
                .set(UserEntity::getPostId, uo.getPostId());

        if (uo.getIsOrgLeader()) {
            organizationService.lambdaUpdate()
                    .eq(OrganizationEntity::getId, uo.getOrgId()).set(OrganizationEntity::getLeaderId, uo.getId()).update();
            userService.lambdaUpdate().set(UserEntity::getDirectLeaderId, uo.getDirectLeaderId());
        }
        userOrgService.saveOrUpdateBatch(uo.getOrgIds());
        List<Integer> ids = uo.getOrgIds().stream().map(UserOrgEntity::getId).collect(Collectors.toList());
        userOrgService.removeByIds(ids);
        List<UserOrgEntity> mainOrg = uo.getOrgIds().stream().filter(UserOrgEntity::getIsMainOrg).collect(Collectors.toList());
        if (mainOrg.size() == ConstConf.SIZE_ONE) {
            userService.lambdaUpdate().set(UserEntity::getOrgId, mainOrg.get(ConstConf.LIST_FIRST).getOrgId());
        } else {
            throw new OaGlobalException("主部门必须只有一个");
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "删除/成员")
    @PostMapping("/delMember")
    public ApiResult<List<DepartmentVo2>> delMember(@RequestBody Integer id) {
        userService.removeById(id);
        return ApiResult.success();
    }


    @ApiOperation(value = "被邀请人列表")
    @GetMapping("/getInviteList")
    public ApiResult<Page<InviteEntity>> getInviteList(Page<InviteEntity> page, InviteEntity inviteEntity) {
        Integer userId = JwtUtil.getUserId();
        LambdaQueryWrapper<InviteEntity> wrapper = new LambdaQueryWrapper<>(inviteEntity)
                .eq(InviteEntity::getUserId, userId)
                .orderBy(true, false, InviteEntity::getCreateTime);
        return ApiResult.success(inviteService.page(page, wrapper));
    }

    @ApiOperation(value = "邀请成员")
    @PostMapping("/invite")
    public ApiResult<Boolean> invite(@RequestBody InviteEntity inviteEntity) {
        // if(inviteEntity.getType()  , "链接邀请"){
        //
        // }

        return ApiResult.success(inviteService.save(inviteEntity));
    }
}