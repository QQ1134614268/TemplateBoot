package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.entity.InviteEntity;
import com.it.oa.config.TreeNode;
import com.it.oa.service.InviteService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Api(tags = "人事管理/组织架构/企业邀请")
@RestController
@RequestMapping("/api/invite")
@Slf4j
public class InviteController {
    public static class InviteType {
        Integer i = 1; //  "链接邀请"
        // Integer i = 1; //  "链接邀请"
        // Integer i = 1; //  "链接邀请"
    }

    public enum InviteTypeEnum implements TreeNode<Integer> {
        LINK(1, "链接邀请");
        private int typeId;
        private String label;

        // String note;
        // Integer i = 1; //  "链接邀请"
        InviteTypeEnum(int typeId, String label) {
            this.typeId = typeId;
            this.label = label;
        }

        @Override
        public Integer getParentId() {
            return null;
        }

        @Override
        public Integer getId() {
            return null;
        }

        @Override
        public List<Integer> getChildren() {
            return null;
        }
    }

    @Resource
    UserService userService;
    @Resource
    private InviteService inviteService;


    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody InviteEntity inviteEntity) {
        return ApiResult.success(inviteService.save(inviteEntity));
    }


    @ApiOperation(value = "是否同意加入企业")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody Integer companyId, Boolean isAgree) {
        Integer userId = JwtUtil.getUserId();
        LambdaUpdateWrapper<InviteEntity> wrapper = new LambdaUpdateWrapper<>();
        // wrapper.eq(InviteEntity::getCompanyId, companyId).eq(InviteEntity::getUserId, userId).set(InviteEntity::getIsAgree, isAgree);
        return ApiResult.success(inviteService.update(wrapper));
    }
}