package com.it.boot.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;
import com.baomidou.mybatisplus.core.conditions.interfaces.Func;
import com.baomidou.mybatisplus.core.conditions.interfaces.Join;
import com.baomidou.mybatisplus.core.conditions.interfaces.Nested;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.AbstractChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.ChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.ChainQuery;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.ChainUpdate;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.mapper.wrapper.MappingQuery;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.boot.config.ApiResult;
import com.it.boot.config.jwt.JwtUtil;
import com.it.boot.entity.dto.UserDto;
import com.it.boot.entity.dto.IdVo;
import com.it.boot.entity.UserEntity;
import com.it.boot.entity.qo.UserQo;
import com.it.boot.service.UserBatisService;
import com.it.boot.util.BoolUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;


@Api(tags = "测试/用户MyBatisPlus")
@RestController
@RequestMapping("/api/UserBatisController")
@Slf4j
public class UserBatisController {
    @Resource
    private UserBatisService userBatisService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userBatisService.save(userEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page<UserEntity> page, UserEntity userEntity) {
        return ApiResult.success(userBatisService.page(page, new QueryWrapper<>(userEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userBatisService.updateById(userEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody Serializable id) {
        return ApiResult.success(userBatisService.removeById(id));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<Integer> ids) {
        return ApiResult.success(userBatisService.removeByIds(ids));
    }

    @ApiOperation(value = "连表")
    @GetMapping("/join")
    public ApiResult<IPage<UserEntity>> join(Page<UserEntity> page, List<Integer> ids) {
        return userBatisService.join(page, ids);
    }

    @ApiOperation(value = "mybatis查询返回dto")
    @GetMapping("/projection")
    public ApiResult<List<UserDto>> projection(IdVo idVo) {
        MPJLambdaWrapper<UserEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(UserEntity::getId, idVo.getId());
        // wrapper.selectAs();
        // wrapper.leftJoin();
        // wrapper.selectFunc()
        // wrapper.selectAll()
        List<UserDto> res = userBatisService.getBaseMapper().selectJoinList(UserDto.class, wrapper);
        return ApiResult.success(res);
    }

    @ApiOperation(value = "测试mybatis 注解查询")
    @GetMapping("/testSelect")
    public ApiResult<UserEntity> testSelect(Integer id) {
        return ApiResult.success(userBatisService.getUserById(id));
    }


    /**
     * @see Query
     * @see     QueryWrapper                    拼接sql
     * @see         QueryChainWrapper               拼接sql chain(??)
     * @see             MappingQuery
     * @see     LambdaQueryChainWrapper
     * @see ChainWrapper
     * @see     ChainQuery                      执行query (list page one count)
     * @see         LambdaQueryWrapper              拼接sql lambdaChain
     * @see         QueryChainWrapper
     * @see     ChainUpdate
     * @see ISqlSegment
     * @see     Wrapper
     * @see         AbstractWrapper
     * @see             QueryWrapper
     * @see             AbstractLambdaWrapper
     * @see                 LambdaQueryWrapper
     * @see         AbstractChainWrapper
     * @see             LambdaQueryChainWrapper
     * @see             QueryChainWrapper
     * @see Mapper
     * @see     BaseMapper                     执行 insert delete selectById selectList(条件)
     * @see Join( Nested , Func , Compare )    and or isNull eq nest in
     * @see     AbstractWrapper
     * @see     AbstractChainWrapper
     * */
    @ApiOperation(value = "测试mybatis 复杂查询")
    @GetMapping("/testMybatis")
    public ApiResult<UserEntity> testMybatis(UserQo qo) {
        // todo
        Consumer<LambdaQueryWrapper<UserEntity>> whereAuth = w -> w
                .or(w2 -> w2.eq(UserEntity::getCreateBy, JwtUtil.getUserId()))
                .or(w2 -> w2.eq(UserEntity::getDeptId, JwtUtil.getDeptId()));

        Consumer<LambdaQueryWrapper<UserEntity>> whereSearch = w -> w.and(
                BoolUtils.toBool( qo.getSearch()),
                w2->w2.like(UserEntity::getUserName, qo.getSearch()).or().like(UserEntity::getPetName, qo.getSearch())
                );

        Consumer<LambdaQueryWrapper<UserEntity>> where = wrapper -> {
            wrapper.first("first");
            wrapper.last("limit 1");
            wrapper.comment("this is comment");

            Consumer<LambdaQueryWrapper<UserEntity>> lambdaQueryWrapperConsumer = w3 -> {
            };
            Consumer<LambdaQueryWrapper<UserEntity>> lambdaQueryChainWrapperConsumer = w -> {
            };

            wrapper.nested(true, lambdaQueryWrapperConsumer);
            wrapper.func(true, lambdaQueryChainWrapperConsumer);
            wrapper.apply(true,"apply sql", 1,2 );
            wrapper.exists(true,   "existsSql", 1,2);
            wrapper.having(true, "having sql");

            wrapper.leSql(true, UserEntity::getUserName, "lesql");
            wrapper.inSql(true, UserEntity::getUserName, "1,2,3");

            wrapper.getExpression();

            wrapper.isEmptyOfWhere();
            wrapper.isEmptyOfNormal();

            wrapper.getSqlSelect();
            wrapper.getTargetSql();
            wrapper.getCustomSqlSegment();
            wrapper.getSqlFirst();
            wrapper.getSqlComment();

            wrapper.getSqlSet();
        };

        userBatisService.lambdaQuery()
                .eq(BoolUtils.toBool( qo.getPhone()), UserEntity::getPhone, qo.getPhone())
                .ge(BoolUtils.toBool(qo.getStartTime() ), UserEntity::getCreateTime, qo.getStartTime() )
                .le(BoolUtils.toBool(qo.getEndTime() ), UserEntity::getCreateTime, qo.getEndTime() )
                .and(true,whereSearch)
                .and(true, whereAuth)
                .and(true, where)
                .orderBy(BoolUtils.toBool(qo.getOrderCreateTime()) ,false, UserEntity::getCreateTime);

        return ApiResult.success();
    }
}