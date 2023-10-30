package com.it.sim.test;

import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.*;

/**
 * @date 2023-05-04 18:21 todo Validator 阅读
 * <pre>
 *  Validator
 *      validate(T var1, Class<?>... var2);
 *      validateProperty
 *      validateValue
 * </pre>
 */
public class TestHandelValid {
    public static void main(String[] args) {
        UserParam userParam = new UserParam();
        Map<String, String> map = BeanValidatorUtil.validateObject(userParam);
        map.forEach((k, v) -> System.out.printf("%s:%s%n", k, v));
        Map<String, String> map2 = BeanValidatorUtil.validateObject(Arrays.asList(userParam, userParam));
        map2.forEach((k, v) -> System.out.printf("%s:%s%n", k, v));

        BeanValidatorUtil.assertCheck(userParam);
    }
}

@Data
class UserParam {

    private Integer id;

    @NotBlank(message = "用户名不可以为空")
    @Size(min = 1, max = 20, message = "用户名长度需要在20个字以内", groups = AddGroup.class)
    private String username;

    @NotBlank(message = "电话不可以为空", groups = {AddGroup.class, EditGroup.class})
    @Pattern(regexp = "^1((3[0-9])|(4[5-9])|(5[0-3,5-9])|(6[5,6])|(7[0-8])|(8[0-9])|(9[189]))[0-9]{8}$", message = "只能是数字")
    @Size(min = 1, max = 13, message = "电话长度需要在13个字以内")
    private String telephone;

    @NotBlank(message = "邮箱不允许为空", groups = {AddGroup.class, EditGroup.class})
    @Pattern(regexp = "^([a-zA-Z]|[0-9])(\\w|\\-)+@[a-zA-Z0-9]+\\.([a-zA-Z]{2,4})$", message = "邮箱格式不正确")
    @Size(min = 5, max = 50, message = "邮箱长度需要在50个字符以内")
    private String mail;

    @NotEmpty
    private List<Integer> lists;

    public interface EditGroup {

    }

    public interface AddGroup {

    }
}

class BeanValidatorUtil {
    public static <T> LinkedHashMap<String, String> validate(T t, Class<?>... groups) {
        Validator validator;
        try (ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory()) {
            validator = VALIDATOR_FACTORY.getValidator();
        }
        Set<ConstraintViolation<T>> validateResult = validator.validate(t, groups);
        LinkedHashMap<String, String> errors = new LinkedHashMap<>();
        //如果为空
        if (!validateResult.isEmpty()) {
            //不为空时表示有错误
            for (ConstraintViolation<T> violation : validateResult) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
        return errors;
    }

    public static Map<String, String> validateObject(Object... objects) {
        for (Object object : objects) {
            LinkedHashMap<String, String> ret = validate(object, object.getClass());
            if (!ret.isEmpty()) {
                return ret;
            }
        }
        return Collections.emptyMap();
    }

    /**
     * 直接抛出异常
     */
    public static void assertCheck(Object param) {
        Map<String, String> map = BeanValidatorUtil.validateObject(param);
        //如果错误集合map不为空则抛出异常
        if (!map.isEmpty()) {
            throw new ValidationException(map.toString());
        }
    }
}
