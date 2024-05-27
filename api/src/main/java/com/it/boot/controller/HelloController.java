package com.it.boot.controller;

import com.alibaba.fastjson2.JSON;
import com.it.boot.config.ApiResult;
import com.it.boot.config.enum1.ResCodeEnum;
import com.it.boot.config.exception.BizException;
import com.it.boot.entity.qo.TimeRangeQo;
import com.it.boot.entity.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
/**
 * 接收数组:
 *      用 @RequestParam
 *      转对象
 *      用 @ModelAttribute
 *      字符串接收, 手动转换
 *      数组接收: Long[] projectIds
 *      post请求 + @RequestBody
 *      post请求 + @RequestBody + 对象
 * */
@Slf4j
@Api(tags = "测试/hello")
@RestController
@RequestMapping("/api/HelloController")
public class HelloController {
    //	由于spring的RequestParam注解接收的参数是来自于requestHeader中，即请求头，也就是在url中，格式为xxx?username=123&password=456，
    //	而RequestBody注解接收的参数则是来自于requestBody中，即请求体中。

    //	在servlet中GET请求可以通过HttpServletRequest的getRequestURL方法和getQueryString()得到完整的请求路径和请求所有参数列表，
    //	POST的需要getParameterMap()方法遍历得到，不论GET或POST都可以通过getRequestURL+getParameterMap()来得到请求完整
    @Resource
    private HttpServletRequest req;

    @Value("${templateBoot.testPort}")
    public Integer port;

    @ApiOperation("/hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }


    @ApiOperation(value = "test")
    @GetMapping(value = "/test")
    public String test(Inner inner0, String all, @RequestParam("all") String all2) {
        log.info(JSON.toJSONString(inner0));
        return JSON.toJSONString(inner0);
    }

    @ApiOperation(value = "configPort")
    @GetMapping("/configPort")
    public ApiResult<Integer> configPort() {
        return ApiResult.success(port);
    }

    @ApiOperation(value = "myException")
    @GetMapping("/myException")
    public ApiResult<Boolean> myException() {
        throw new BizException(ResCodeEnum.RES_FAILURE.getCode(), "MyException");
    }

    // http://127.0.0.1:9091/hello/name?name= -------输出--"" 空串
    // http://127.0.0.1:9091/hello/name? -------输出--null 没有
    // http://127.0.0.1:9091/hello/name?name=tom&name=kate  // name=tom,kate
    @ApiOperation(value = "name", consumes = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/name", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResult<String> name(String name) {//
        return ApiResult.success(name);
    }

    // GET http://localhost:9091/api/HelloController/enumTest?resCodeEnum=RES_SUCCESS
    @ApiOperation(value = "enumTest")
    @GetMapping("/enumTest")
    public String enumTest(ResCodeEnum resCodeEnum) {
        System.err.println(resCodeEnum.getCode());
        return resCodeEnum.getLabel();
    }

    // GET http://localhost:9091/api/HelloController/date?date=Oct 20 20:27:37 CST 2018
    // GET http://localhost:9091/api/HelloController/date?date=2000-01-01 00:00:00
    @ApiOperation(value = "date")
    @GetMapping("/date")
    public ApiResult<String> date(Date date) {
        System.err.println("接收到 Date 参数: " + date);
        return ApiResult.success();
    }

    // list接收方式 1,数组; 2,对象接收; 3,string自行转换; 4, body接收(post)
    // GET http://localhost:9091/api/HelloController/getArray?array=1,2,3
    @ApiOperation(value = "getArray")
    @GetMapping("/getArray")
    public int[] getArray(int[] array) {
        System.err.println("接收到int[] array参数: " + Arrays.toString(array));
        return array;
    }

    /**
     * springboot 参数映射方式
     * <br/>
     * 没有 @RequestBody,从param中取值, 多个@RequestBody报IOException: Stream closed 异常
     */
    @ApiOperation(value = "studentVo_name")
    @PostMapping("/studentVo_name")
    public ApiResult<StudentVO> studentVo_name(@RequestBody StudentVO vo, String name) {
        System.err.println(vo.toString() + name);
        return ApiResult.success(vo);
    }

    @GetMapping("/printRequest")
    @ApiOperation(value = "printRequest")
    public ApiResult<String> printRequest() {
        log.info(req.getRequestURI());
        log.info("RequestURL:  " + req.getRequestURL().toString());
        log.info("QueryString: " + req.getQueryString());

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            System.err.println("header: " + key + " = " + value);
        }

        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = req.getParameterValues(paramName);
            if (paramValues.length == 1) {
                if (paramValues[0].length() != 0) {
                    System.err.println("param: " + paramName + " = " + paramValues[0]);
                }
            }
        }
        return ApiResult.success();
    }

    @GetMapping("/asyncReq")
    @ApiOperation(value = "asyncReq")
    public boolean asyncReq() {
        // Thread.currentThread().setDaemon(false); // 不能设置
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
                log.info("Thread: " + new Date());
                log.info("Thread: " + Thread.currentThread().isDaemon());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // 当前线程是守护线程, 不会等待创建的子线程(非守护)?? 线程之间的关系(线程没有父子,线程组?? )
        t.setDaemon(false);
        t.start();
        log.info("ret: " + new Date());
        return Thread.currentThread().isDaemon();
    }

    @ApiOperation(value = "testValidated")
    @GetMapping("/testValidated")
    public ApiResult<TimeRangeQo> testValidated(@Validated TimeRangeQo qo) {
        return ApiResult.success(qo);
    }
}
