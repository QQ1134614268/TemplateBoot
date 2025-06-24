package com.it.ws.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
@WebService
public class UserServiceImpl implements UserService {
    private final Map<Long, User> userMap = new HashMap<>();

    {
        User user = new User();
        user.setId(1L);
        user.setName("张三");
        user.setAge(18);
        user.setBirthday("1987-12-15");
        user.setHobbies(Arrays.asList("吃饭", "睡觉"));
        userMap.put(1L, user);

        user = new User();
        user.setId(2L);
        user.setName("李四");
        user.setAge(15);
        user.setBirthday("1991-03-03");
        user.setHobbies(Arrays.asList("游泳", "下棋"));
        userMap.put(2L, user);

        user = new User();
        user.setId(3L);
        user.setName("王五");
        user.setAge(12);
        user.setBirthday("1994-03-03");
        user.setHobbies(Arrays.asList("打游戏", "读书"));
        userMap.put(3L, user);
    }

    @Override
    //    @WebMethod 不对方法单独设置，则无需加此注解，以默认配置暴露该方法
    @WebResult(name = "res")
    public User getById(@WebParam(name = "req") User user) {
        User res = userMap.get(user.getId());
        Assert.notNull(res, user.getId() + " 用户不存在");
        return res;
    }
}

