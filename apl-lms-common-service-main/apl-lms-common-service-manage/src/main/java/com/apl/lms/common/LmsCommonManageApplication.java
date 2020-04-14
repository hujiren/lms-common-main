package com.apl.lms.common;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.apl.lms.common", "com.apl.lms.common", "com.apl.lib", "com.apl.lib.datasource", "com.apl.lib.handler"})
@MapperScan(basePackages = {"com.apl.lms.common.mapper"})
@EnableSwagger2
public class LmsCommonManageApplication {

    public static void main(String[] args) {

        SpringApplication.run(LmsCommonManageApplication.class , args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){

        PaginationInterceptor page = new PaginationInterceptor();

        page.setDialectType("mysql");
        return page;
    }
}
