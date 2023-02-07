package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.config.enumeration.ResCodeEnum;
import com.it.boot.config.exception.BizException;
import com.it.boot.config.redis.RedisUtils;
import com.it.boot.dao.projection.UserProjection;
import com.it.boot.dao.repository.UserJpaRepository;
import com.it.boot.dto.MessageDto;
import com.it.boot.dto.TestDateDto;
import com.it.boot.dto.UserOnly;
import com.it.boot.entity.TestDateEntity;
import com.it.boot.entity.UserEntity;
import com.it.boot.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Api(tags = "测试/hello")
@RestController
@RequestMapping("/api/TestHelloController")
public class TestHelloController {
    //	由于spring的RequestParam注解接收的参数是来自于requestHeader中，即请求头，也就是在url中，格式为xxx?username=123&password=456，
    //	而RequestBody注解接收的参数则是来自于requestBody中，即请求体中。

    //	在servlet中GET请求可以通过HttpServletRequest的getRequestURL方法和getQueryString()得到完整的请求路径和请求所有参数列表，
    //	POST的需要getParameterMap()方法遍历得到，不论GET或POST都可以通过getRequestURL+getParameterMap()来得到请求完整
    @Resource
    private HttpServletRequest req;

    @Resource
    private UserJpaRepository userJpaRepository;
    @Resource
    private RedisUtils redisUtils;

    @Value("${templateBoot.testPort}")
    public Integer port;

    @GetMapping("/hello")
    @ApiOperation("/hello")
    public String hello() {
        return "hello world!";
    }


    @GetMapping("/configPort")
    @ApiOperation(value = "configPort")
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
    public ApiResult<String> name(String name) throws IOException {//
        return ApiResult.success(name);
    }

    // GET http://localhost:9091/api/HelloController/enumTest?resCodeEnum=RES_SUCCESS
    @GetMapping("/enumTest")
    @ApiOperation(value = "enumTest")
    public String enumTest(ResCodeEnum resCodeEnum) {
        System.err.println(resCodeEnum.getCode());
        return resCodeEnum.getNote();
    }

    // GET http://localhost:9091/api/HelloController/date?date=Oct 20 20:27:37 CST 2018
    // GET http://localhost:9091/api/HelloController/date?date=2000-01-01 00:00:00
    @GetMapping("/date")
    @ApiOperation(value = "date")
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

    /*
     *测试jpa 投影
     */
    @GetMapping("/projections")
    @ApiOperation(value = "测试jpa 投影")
    public Map<String, Object> projection() {
        Map<String, Object> map = new HashMap<>();
        Collection<UserProjection> projections = userJpaRepository.findAllNameAndEmail();
        System.out.println(projections);
        System.out.println(projections.size());
        for (UserProjection u : projections) {
            map.put("userName:", u.getUserName());
            map.put("email:", u.getEmail());
            map.put("information:", u.getInformation());
        }
        return map;
    }

    /*
     *测试jpa dto
     */
    @GetMapping("/testJpaDto")
    @ApiOperation(value = "testJpaDto")
    public List<UserOnly> testJpaDto() {
        UserEntity userEntity = userJpaRepository.findByUserNameAndEmail("tom", "test@test.com", UserEntity.class);
        System.out.println(userEntity);
        List<UserOnly> userOnlyList = userJpaRepository.findByUserName("tom", UserOnly.class);
        System.out.println(userOnlyList);
        return userOnlyList;
    }

    @GetMapping("/getNativeQuery")
    @ApiOperation("getNativeQuery")
    public ApiResult<TestDateEntity> getNativeQuery() {
        TestDateEntity vo = userJpaRepository.getNativeQuery(1);
        return ApiResult.success(vo);
    }

    @GetMapping("/getNativeQuery2")
    @ApiOperation("getNativeQuery2")
    public ApiResult<TestDateDto> getNativeQuery2() {
        // TestDateDto 需要 @entity标记
        TestDateDto vo = userJpaRepository.getNativeQuery2(1);
        return ApiResult.success(vo);
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

    @ApiOperation(value = "发布redis消息")
    @GetMapping("/publishRedisMessage")
    public void publishRedisMessage(String topic, String title, String content) {
        // 发布消息
        MessageDto dto = new MessageDto();
        dto.setData(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        dto.setTitle(title);
        dto.setContent(content);
        redisUtils.convertAndSend(topic, dto);
    }
}
