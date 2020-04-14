package com.apl.lms.common.config;


import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Component
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 全局参数(如header中的token)
     *
     * @return List<Parameter>
     */
    private List<Parameter> parameter() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("token")
                .description("请求令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build());
        return params;
    }

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(basePackage("com.apl.lms.common.controller"))
                //过滤生成链接
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameter());
    }

    //api接口作者相关信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("arran", "", "1223280088@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .license("Apache License Version 2.0")
                .title("apl-lms-common-query")
                .description("LMS-公共数据-查询")
                .contact(contact)
                .version("1.0.0")
                .build();
        return apiInfo;
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(";")) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());

    }
}
