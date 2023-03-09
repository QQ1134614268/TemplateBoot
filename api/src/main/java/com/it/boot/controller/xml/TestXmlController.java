package com.it.boot.controller.xml;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@Hidden
public class TestXmlController {

    @RequestMapping(value = "/creditLoanApplyNotify", method = RequestMethod.POST,consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String creditLoanApplyNotify(@RequestBody CreditLoanApplyNotifyDto req) {
// 自己逻辑
    }

}
