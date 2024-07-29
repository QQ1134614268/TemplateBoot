package com.it.boot.controller;

import com.alibaba.fastjson2.JSON;
import com.it.boot.config.ApiResult;
import com.it.boot.config.enum1.ResCodeEnum;
import com.it.boot.config.exception.BizException;
import com.it.boot.entity.qo.StudentQo;
import com.it.boot.entity.qo.TimeRangeQo;
import com.it.boot.entity.vo.StudentVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;


@Slf4j
@Tag(name = "测试/hello")
@RestController
@RequestMapping("/api/HelloController")
public class HelloController {


    @Value("${templateBoot.testPort}")
    public Integer port;

    @Operation(summary = "/hello")
    @GetMapping("/hello")
    public String hello() { // 返回String: Content-Type: text/plain; 返回对象: Content-Type: application/json
        return "hello world!";
    }

    /**
     * 由于spring的RequestParam注解接收的参数是来自于requestHeader中，即请求头，也就是在url中，格式为xxx?username=123&password=456，
     * 而RequestBody注解接收的参数则是来自于requestBody中，即请求体中。
     */
    @Operation(summary = "testName")
    @GetMapping(value = "/testName")
    public ApiResult<StudentQo> testName(String name, @RequestParam(value = "name", required = false) String name2, StudentQo studentQo) {
        // ?name=tom        "tom"
        // ?name=           ""
        // ?                 null

        // 默认 从url取值; 根据参数类型, 赋值
        log.info(name);
        log.info(name2);
        log.info(JSON.toJSONString(studentQo));
        return ApiResult.success(studentQo);
    }

    // GET http://localhost:9091/api/HelloController/testDate?date=Oct 20 20:27:37 CST 2018
    // GET http://localhost:9091/api/HelloController/testDate?date=2000-01-01 00:00:00
    @Operation(summary = "testDate")
    @GetMapping("/testDate")
    public ApiResult<String> testDate(Date date) {
        System.err.println("接收到 Date 参数: " + date);
        return ApiResult.success();
    }

    @Operation(summary = "testRequestBody")
    @PostMapping("/testRequestBody")
    public ApiResult<StudentVO> testRequestBody(@RequestBody StudentVO vo) { // RequestBody 只从 body中取值, 只能有一个
        log.info(JSON.toJSONString(vo));
        return ApiResult.success(vo);
    }
    /**
     * 接收数组:
     * 用 @RequestParam
     * 用对象
     * 用 @ModelAttribute
     * 字符串接收, 手动转换
     * 数组接收: Long[] projectIds
     * <br/>
     * post请求 + @RequestBody
     * post请求 + @RequestBody + 对象
     */
    // GET http://localhost:9091/api/HelloController/testArray?array=1,2,3
    @Operation(summary = "testArray")
    @RequestMapping(value = "/testArray", method = {RequestMethod.GET, RequestMethod.POST})
    public int[] testArray(int[] array) {
        System.err.println("接收到int[] array参数: " + Arrays.toString(array));
        return array;
    }

    // GET http://localhost:9091/api/HelloController/testEnum?codeEnum=SUCCESS
    @Operation(summary = "testEnum")
    @GetMapping("/enumTest")
    public String testEnum(ResCodeEnum codeEnum) {
        System.err.println(codeEnum.getCode());
        return codeEnum.getLabel();
    }

    @Operation(summary = "configPort")
    @GetMapping("/configPort")
    public ApiResult<Integer> configPort() {
        return ApiResult.success(port);
    }

    @Operation(summary = "testException")
    @GetMapping("/testException")
    public ApiResult<Boolean> testException() {
        throw new BizException(ResCodeEnum.FAILURE.getCode(), "MyException");
    }

    /**
     * consumes: 指定请求(request)中的 Content-Type
     * produces: 指定返回(response)的 Content-Type; application/json: 支持序列化对象, TEXT_PLAIN_VALUE: 仅支持返回String类型
     * <p>
     * produces 不支持会报 No converter for [class com.it.boot.config.ApiResult] with preset Content-Type 'null'
     */
    @Operation(summary = "testContentType")
    @PostMapping(value = "/testContentType",
            consumes = {MediaType.APPLICATION_JSON_VALUE},  // 指定 Content-Type: application/json
            produces = {MediaType.APPLICATION_JSON_VALUE})  // 指定返回 Content-Type: application/json, 并序列化
    public ApiResult<String> testContentType(String name) {
        log.info(name);
        return ApiResult.success(name);
    }

    @GetMapping(value = "/testResponseHeader")
    public ApiResult<Boolean> testResponseHeader(HttpServletResponse response) {
        // 被重写, @RequestMapping produces参数可指定
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        return ApiResult.success(true);
    }

    /**
     * 在servlet中GET请求可以通过HttpServletRequest的getRequestURL方法和getQueryString()得到完整的请求路径和请求所有参数列表，
     * POST的需要getParameterMap()方法遍历得到，不论GET或POST都可以通过getRequestURL+getParameterMap()来得到请求完整
     */
    @GetMapping("/printRequest")
    @Operation(summary = "printRequest")
    public ApiResult<String> printRequest(HttpServletRequest req) {
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
                if (!paramValues[0].isEmpty()) {
                    System.err.println("param: " + paramName + " = " + paramValues[0]);
                }
            }
        }
        return ApiResult.success();
    }

    @GetMapping("/asyncReq")
    @Operation(summary = "asyncReq")
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

    @Operation(summary = "testValidated")
    @GetMapping("/testValidated")
    public ApiResult<TimeRangeQo> testValidated(@Validated TimeRangeQo qo) {
        return ApiResult.success(qo);
    }
}
