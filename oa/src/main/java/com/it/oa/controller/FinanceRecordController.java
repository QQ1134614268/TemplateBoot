package com.it.oa.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.excel.ExcelListener;
import com.it.oa.config.exception.OaGlobalException;
import com.it.oa.controller.dto.FinanceRecordDto;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.controller.para.FinanceExcelVO;
import com.it.oa.controller.para.FinancePara;
import com.it.oa.entity.FinanceRecordEntity;
import com.it.oa.entity.FinanceTypeEntity;
import com.it.oa.entity.PayConfigEntity;
import com.it.oa.mapper.FinanceRecordMapper;
import com.it.oa.service.FinanceRecordService;
import com.it.oa.service.FinanceTypeService;
import com.it.oa.service.PayConfigService;
import com.it.oa.util.FrontUtil;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.it.oa.util.StringUtil.toBool;


@Api(tags = "财务管理/账目记录/收支记账")
@RestController
@RequestMapping("/api/financeRecord")
@Slf4j
public class FinanceRecordController {
    @Resource
    private FinanceRecordService financeRecordService;
    @Resource
    private FinanceRecordMapper financeRecordMapper;
    @Resource
    private PayConfigService payConfigService;
    @Resource
    private FinanceTypeService financeTypeService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody FinanceRecordEntity financeRecordEntity) {
        financeRecordEntity.setFinanceTypeId(FrontUtil.getLast(financeRecordEntity.getFinanceTypeIds()));
        return ApiResult.success(financeRecordService.save(financeRecordEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<FinanceRecordDto>> getPage(Page<FinanceRecordEntity> page, FinancePara para) {
        MPJLambdaWrapper<FinanceRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(FinanceTypeEntity.class, FinanceTypeEntity::getId, FinanceRecordEntity::getFinanceTypeId);
        wrapper.select(FinanceTypeEntity::getType);
        wrapper.leftJoin(PayConfigEntity.class, PayConfigEntity::getId, FinanceRecordEntity::getPayTypeId);

        wrapper.between(toBool(para.getStartTime()), FinanceRecordEntity::getPayTime, para.getStartTime(), para.getEndTime())
                .eq(toBool(para.getPayTypeId()), FinanceRecordEntity::getPayTypeId, para.getPayTypeId())
                .eq(toBool(para.getCategory()), FinanceTypeEntity::getCategory, para.getCategory());

        wrapper.selectAll(FinanceRecordEntity.class);
        wrapper.select(FinanceTypeEntity::getCategory);
        wrapper.selectAs(PayConfigEntity::getPayNameCn, FinanceRecordDto::getPayType);

        IPage<FinanceRecordDto> ret = financeRecordMapper.selectJoinPage(page, FinanceRecordDto.class, wrapper);
        // todo  FinanceTypeIds
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody FinanceRecordEntity financeRecordEntity) {
        financeRecordEntity.setFinanceTypeId(FrontUtil.getLast(financeRecordEntity.getFinanceTypeIds()));
        return ApiResult.success(financeRecordService.updateById(financeRecordEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(financeRecordService.removeById(para.getId()));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(financeRecordService.removeByIds(para.getIds()));
    }


    @ApiOperation(value = "上传")
    @PostMapping("/upload")
    public ApiResult<Boolean> upload(@RequestPart("file") MultipartFile file) throws IOException {
        ExcelListener<FinanceExcelVO> listener = new ExcelListener<>();
        ExcelReader excelReader = EasyExcel.read(file.getInputStream(), FinanceExcelVO.class, listener).build();
        excelReader.readAll();
        List<FinanceExcelVO> list = listener.getList();
        excelReader.finish();
        List<FinanceRecordEntity> newList = new ArrayList<>();
        for (FinanceExcelVO vo : list) {
            FinanceRecordEntity entity = new FinanceRecordEntity();

            if (toBool(vo.getPayType())) {
                PayConfigEntity payConfigEntity = new PayConfigEntity();
                payConfigEntity.setPayNameCn(vo.getPayType());
                payConfigEntity = payConfigService.getOne(new QueryWrapper<>(payConfigEntity));
                if (payConfigEntity == null) {
                    return ApiResult.fail("支付方式不存在!");
                }
                entity.setPayTypeId(payConfigEntity.getId());
            }
            entity.setFinanceMoney(vo.getFinanceMoney());
            entity.setNote(vo.getNote());
            entity.setFinanceTypeId(getType(vo.getCategory(), vo.getType()));
            entity.setPayTime(vo.getPayTime());
            newList.add(entity);
        }
        financeRecordService.saveOrUpdateBatch(newList);
        return ApiResult.success();
    }

    public Integer getType(String category, String typeStr) {
        if (!StringUtil.toBool(category)) {
            throw new OaGlobalException("账目类型不能为空");
        }
        if (!StringUtil.toBool(typeStr)) {
            throw new OaGlobalException("账目分类不能为空");
        }

        FinanceTypeEntity financeTypeEntity = new FinanceTypeEntity();
        financeTypeEntity.setCategory(category);
        financeTypeEntity.setType(typeStr);
        List<FinanceTypeEntity> db = financeTypeService.list(new QueryWrapper<>(financeTypeEntity));
        if (db.isEmpty()) {
            financeTypeService.save(financeTypeEntity);
            return financeTypeEntity.getId();
        } else {
            return db.get(0).getId();
        }
    }

    @ApiOperation(value = "下载")
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        // getPage(new Page(-1,10),new FinancePara());
        // List<FinanceRecordEntity> data = financeRecordService.list();
        //
        // List<FinanceExcelVO> newList = data.stream().map(vo -> {
        //     FinanceExcelVO entity = new FinanceExcelVO();
        //     entity.setFinanceMoney(vo.getFinanceMoney());
        //     entity.setNote(vo.getNote());
        //     return entity;
        // }).collect(Collectors.toList());
        // FinanceExcelVO entity = new FinanceExcelVO();
        // entity.setNote("注意");
        // newList.add(entity);
        // ExcelUtil.writeExcel(response, "收支记账", newList, FinanceExcelVO.class);
    }
}