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
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.boot.config.ApiResult;
import com.it.boot.entity.UserEntity;
import com.it.boot.entity.dto.IdVo;
import com.it.boot.entity.dto.UserDto;
import com.it.boot.entity.qo.UserQo;
import com.it.boot.service.UserBatisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;


@Tag(name = "测试/用户MyBatisPlus")
@RestController
@RequestMapping("/api/UserBatisController")
@Slf4j
public class UserBatisController {
    @Resource
    private UserBatisService userBatisService;

    @Operation(summary = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userBatisService.save(userEntity));
    }

    @Operation(summary = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page<UserEntity> page, UserEntity userEntity) {
        return ApiResult.success(userBatisService.page(page, new QueryWrapper<>(userEntity)));
    }

    @Operation(summary = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userBatisService.updateById(userEntity));
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody Serializable id) {
        return ApiResult.success(userBatisService.removeById(id));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<Integer> ids) {
        return ApiResult.success(userBatisService.removeByIds(ids));
    }

    @Operation(summary = "连表")
    @GetMapping("/join")
    public ApiResult<IPage<UserEntity>> join(Page<UserEntity> page, List<Integer> ids) {
        return userBatisService.join(page, ids);
    }

    @Operation(summary = "mybatis查询返回dto")
    @GetMapping("/mpjDtoProjection")
    public ApiResult<List<UserDto>> mpjDtoProjection(IdVo idVo) {
        MPJLambdaWrapper<UserEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(UserEntity::getId, idVo.getId());
        // wrapper.selectAs();
        // wrapper.leftJoin();
        // wrapper.selectFunc()
        // wrapper.selectAll()
        List<UserDto> res = userBatisService.getBaseMapper().selectJoinList(UserDto.class, wrapper);
        return ApiResult.success(res);
    }

    @Operation(summary = "测试mybatis 注解查询")
    @GetMapping("/testSelect")
    public ApiResult<UserEntity> testSelect(Integer id) {
        return ApiResult.success(userBatisService.getUserById(id));
    }


    /**
     * <pre>
     * @see Query
     * @see     QueryWrapper                    拼接sql
     * @see         QueryChainWrapper               拼接sql chain(??)
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
     *
     *         // QueryChainWrapper select 使用 字符串,可以拼接函数,自定义字段
     *         // LambdaQueryChainWrapper select 使用SFunction, 自定义字段??
     *         // 继承 AbstractChainWrapper方法, 众多sql字符相关,不能使用(getSqlSelect,getSqlComment,getTargetSql,getSqlSet,getCustomSqlSegment)
     * </pre>
     */
    @Operation(summary = "测试 LambdaQueryChainWrapper 复杂查询")
    @GetMapping("/testLambdaQueryChainWrapper")
    public ApiResult<List<UserEntity>> testLambdaQueryChainWrapper(UserQo qo) {
        LambdaQueryChainWrapper<UserEntity> query = userBatisService.lambdaQuery();
        Consumer<LambdaQueryWrapper<UserEntity>> whereAuth = w -> w.or(w2 -> w2.eq(UserEntity::getCreateBy, 1)
                .eq(UserEntity::getCreateBy, 2)).or(w2 -> w2.eq(UserEntity::getDeptId, 1).eq(UserEntity::getDeptId, 2));

        Consumer<LambdaQueryWrapper<UserEntity>> whereSearch = w -> w.like(UserEntity::getUserName, qo.getSearch())
                .or()
                .like(UserEntity::getNickName, qo.getSearch());
        query.select(UserEntity::getId, UserEntity::getUserName, UserEntity::getPhone)
                .isNotNull(true, UserEntity::getUserName)
                .leSql(true, UserEntity::getId, "10") //  id < 10
                .inSql(true, UserEntity::getId, "1,2") // id in (1, 2)
                .nested(true, w -> w.eq(UserEntity::getId, "1").or().eq(UserEntity::getId, "2"))
                .func(true, w -> w.eq(UserEntity::getId, "5"))
                .apply(true, "1=1", 1)
                // .exists(true, "exists_Sql3", 1, 2)
                // .allEq(new HashMap<>())
                .and(true, whereSearch)
                .and(true, whereAuth)
                .groupBy(true, UserEntity::getId)
                // .having(true, "having_sql4")
                .orderBy(true, false, UserEntity::getCreateTime)
                // .first("# first \n")
                .last("# last \n")
                .comment("# this is comment\n");

        // wrapper.isEmptyOfWhere();
        // wrapper.nonEmptyOfWhere();
        // wrapper.isEmptyOfNormal();
        // wrapper.nonEmptyOfNormal();
        // wrapper.nonEmptyOfEntity();

        // wrapper.getExpression();

        // wrapper.getSqlFirst();
        // wrapper.getSqlComment();
        // wrapper.getSqlSelect();
        // wrapper.getTargetSql();
        // wrapper.getSqlSet();
        // wrapper.getCustomSqlSegment();
        // wrapper.getExpression();
        // wrapper.getEntity();

        List<UserEntity> res = query.list();
        return ApiResult.success(res);
    }

    @Operation(summary = "测试 QueryChainWrapper 复杂查询")
    @GetMapping("/testMybatis2")
    public void testQueryChainWrapper() {
        QueryChainWrapper<UserEntity> wrapper = new QueryChainWrapper<>(userBatisService.getBaseMapper());
        wrapper.select("id");

        log.info(wrapper.getSqlFirst());

    }

    @Operation(summary = "测试 LambdaQueryWrapper 复杂查询")
    @GetMapping("/testLambdaQueryWrapper")
    public void testLambdaQueryWrapper() {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(UserEntity::getId);

        log.info(wrapper.getSqlFirst());
    }

    @Operation(summary = "测试 QueryWrapper 复杂查询")
    @GetMapping("/testQueryWrapper")
    public void testQueryWrapper() {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.select("id");

        log.info(wrapper.getSqlFirst());
    }
}