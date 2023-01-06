package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.config.ConstConf;
import com.it.oa.controller.dto.MenuDTO;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.BaseEntity;
import com.it.oa.entity.MenuEntity;
import com.it.oa.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Api(tags = "系统管理/系统设置/菜单管理")
@RestController
@RequestMapping("/api/menu")
@Slf4j
public class MenuController {
    @Resource
    private MenuService menuService;

    // @ApiOperation(value = "新增")
    // @PostMapping("/create")
    // public ApiResult create(@RequestBody MenuEntity menuEntity) {
    //     return ApiResult.success(menuService.save(menuEntity));
    // }

    @ApiOperation("获取菜单")
    @GetMapping("/getMenuTree")
    public ApiResult<List<MenuDTO>> getMenuTree() {
        List<MenuEntity> all = menuService.lambdaQuery().orderByAsc(MenuEntity::getParentId, MenuEntity::getMenuOrder)
                .orderByAsc(MenuEntity::getParentId, MenuEntity::getMenuOrder)
                .list();

        List<MenuDTO> org = all.stream().map(entity -> {
            MenuDTO vo = new MenuDTO();
            vo.setId(entity.getId());
            vo.setParentId(entity.getParentId());
            vo.setMenuName(entity.getMenuName());
            return vo;
        }).collect(Collectors.toList());

        List<MenuDTO> tree = new ArrayList<>();
        for (MenuDTO entity : org) {
            if (Objects.equals(entity.getParentId(), ConstConf.Parent_ID_ZERO)) {
                tree.add(entity);
            }
            for (MenuDTO entity1 : org) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
        }
        return ApiResult.success(tree);
    }

    @ApiOperation("选中的菜单")
    @GetMapping("/getSelectMenuIds")
    public ApiResult<List<Integer>> getSelectMenuIds() {
        return ApiResult.success(
                menuService.lambdaQuery().select(MenuEntity::getId).eq(MenuEntity::getIsSelect, true).list()
                        .stream().map(BaseEntity::getId).collect(Collectors.toList())
        );
    }

    @ApiOperation(value = "选中的菜单的id")
    @PostMapping("/updateSelectIds")
    public ApiResult<Boolean> updateSelectIds(@RequestBody DelParaList para) {
        menuService.lambdaUpdate().in(MenuEntity::getId, para.getIds()).set(MenuEntity::getIsSelect, true).update();
        menuService.lambdaUpdate().notIn(MenuEntity::getId, para.getIds()).set(MenuEntity::getIsSelect, false).update();
        return ApiResult.success();
    }
}