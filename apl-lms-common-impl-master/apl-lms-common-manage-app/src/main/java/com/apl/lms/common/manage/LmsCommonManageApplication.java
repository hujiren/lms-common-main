package com.apl.lms.common.manage;

import com.apl.lib.config.MyBatisPlusConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.apl.lib", "com.apl.datasource", "com.apl.lms.common"},exclude = {DataSourceAutoConfiguration.class, MyBatisPlusConfig.class})
@MapperScan(basePackages = {"com.apl.lms.common.mapper"})
@EnableSwagger2
@EnableDiscoveryClient
public class LmsCommonManageApplication {

    public static void main(String[] args) {

        //com.apl.lib.datasource.DataSourceConfig

        SpringApplication.run(LmsCommonManageApplication.class , args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

}
