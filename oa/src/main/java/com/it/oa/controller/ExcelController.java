package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.service.ExcelService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@Hidden
@RestController
@RequestMapping("/api/excel")
@Slf4j
public class ExcelController {
    @Resource
    private ExcelService excelService;

    @Operation(summary = "上传Excel")
    @PostMapping("/importAttendanceExcel")
    public ApiResult<String> importAttendanceExcel(@RequestPart("file") MultipartFile file) {
        excelService.importAttendanceExcel(file);
        return ApiResult.success();
    }


    @Operation(summary = "上传")
    @PostMapping("/exportAttendanceExcel")
    public void exportAttendanceExcel() {
        excelService.exportAttendanceExcel();
    }

}