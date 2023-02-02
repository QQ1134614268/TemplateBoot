package com.it.ws.service;
import lombok.Data;
import java.util.List;

@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String birthday;
    // WebService 对参数类型有限制 无法直接使用 LocalDate
//    private LocalDate birthday;
    private List<String> hobbies;
}
