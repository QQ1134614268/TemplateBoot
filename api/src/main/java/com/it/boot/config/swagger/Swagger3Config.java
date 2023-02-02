// package com.it.boot.config.swagger;
//
// import com.it.oa.util.JwtUtil;
// import io.swagger.annotations.Api;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.builders.RequestParameterBuilder;
// import springfox.documentation.oas.annotations.EnableOpenApi;
// import springfox.documentation.schema.ScalarType;
// import springfox.documentation.service.*;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spi.service.contexts.SecurityContext;
// import springfox.documentation.spring.web.plugins.Docket;
//
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
// //  <groupId>io.springfox</groupId>
// //       <artifactId>springfox-swagger2</artifactId>
// //  <version>3.0.0</version>
// //  注解不好用
// @Configuration
// @EnableOpenApi
// public class Swagger3Config {
//
//     @Bean
//     public Docket createRestApi() {
//         String tokenStr = JwtUtil.toToken(1, "test");
//
//         RequestParameterBuilder tokenPar = new RequestParameterBuilder();
//         List<RequestParameter> pars = new ArrayList<>();
//         pars.add(tokenPar.build());
//         RequestParameterBuilder builder = new RequestParameterBuilder()
//                 .in(ParameterType.HEADER)
//                 .required(true).name("Authorization").query(m -> m.model(n -> n.scalarModel(ScalarType.STRING)).defaultValue(tokenStr));
//         pars.add(builder.build());
//         // return new Docket(DocumentationType.OAS_30)
//         //         .apiInfo(apiInfo())
//         //         // .protocols(Collections.singleton("http"))
//         //         .select()
//         //         .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//         //         .paths(PathSelectors.any()).build()
//         //         .globalRequestParameters(pars);
//
//         return new Docket(DocumentationType.OAS_30)
//                 .apiInfo(apiInfo())
//                 .select()
//                 .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                 .paths(PathSelectors.any())
//                 .build()
//                 .securityContexts(Arrays.asList(securityContext()))
//                 // ApiKey的name需与SecurityReference的reference保持一致
//                 // .globalRequestParameters(pars)
//                 .securitySchemes(Arrays.asList(new ApiKey("Authorization", "Authorization", SecurityScheme.In.HEADER.name())));
//     }
//
//     private SecurityContext securityContext() {
//         return SecurityContext.builder()
//                 .securityReferences(defaultAuth())
//                 //.forPaths(PathSelectors.regex("/*.*"))
//                 .build();
//     }
//
//     private List<SecurityReference> defaultAuth() {
//         AuthorizationScope[] authorizationScopes = {new AuthorizationScope("Authorization", "accessEverything")};
//         return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
//     }
//
//     private ApiInfo apiInfo() {
//         return new ApiInfoBuilder()
//                 .title("Swagger3接口文档")
//                 .description("更多请咨询服务开发者。")
//                 .contact(new Contact("", "", "xx@it.com"))
//                 .version("1.0")
//                 .build();
//     }
//
//
//     //// springboot2.6.x Failed to start bean 'documentationPluginsBootstrapper';
//     //    @Bean
//     //    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//     //        return new BeanPostProcessor() {
//     //            @Override
//     //            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//     //                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
//     //                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
//     //                }
//     //                return bean;
//     //            }
//     //
//     //            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
//     //                List<T> copy = mappings.stream().filter(mapping -> mapping.getPatternParser() == null).collect(Collectors.toList());
//     //                mappings.clear();
//     //                mappings.addAll(copy);
//     //            }
//     //
//     //            @SuppressWarnings("unchecked")
//     //            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
//     //                try {
//     //                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
//     //                    field.setAccessible(true);
//     //                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
//     //                } catch (IllegalArgumentException | IllegalAccessException e) {
//     //                    throw new IllegalStateException(e);
//     //                }
//     //            }
//     //        };
//     //    }
// }
//
