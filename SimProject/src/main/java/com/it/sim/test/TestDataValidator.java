package com.it.sim.test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.HibernateValidator;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 *  Validator
 *      validate(T var1, Class<?>... var2);
 *      validateProperty
 *      validateValue
 * </pre>
 */
public class TestDataValidator {
    @Test
    public void test1() {
        Model model = new Model();
        model.setName("");
        model.setAge(-1);
        Set<ConstraintViolation<Model>> validatorResult = ValidatorUtil.validate(model, Model.EditGroup.class, Default.class);
        System.out.println(validatorResult.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(",")));
    }
}


@Data
class Model {

    @NotNull(message = "id不能为空", groups = EditGroup.class)
    @Null(message = "id不能有值", groups = AddGroup.class)
    private Long id;

    @Size(min = 3, max = 20, message = "名称长度不能小于3位且不能大于20位")
    @NotBlank(message = "名称不能为空")
    private String name;

    @Max(value = 150, message = "年龄最大150岁")
    @Min(value = 18, message = "年龄最小18岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;

    public interface EditGroup {

    }

    public interface AddGroup {

    }
}


/**
 * 校验框架工具类
 */
final class ValidatorUtil {

    private static final Validator validator;

    static {
        try (ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory()) {
            validator = validatorFactory
                    .getValidator();
        }
    }

    public static <T> Set<ConstraintViolation<T>> validate(T obj, Class<?>... groups) {
        return validator.validate(obj, groups);
    }
}