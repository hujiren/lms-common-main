package com.apl.lms.common.query;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.apl.lib", "com.apl.datasource", "com.apl.lms.common"},exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.apl.lms.common.mapper"})
@EnableSwagger2
@EnableFeignClients(basePackages = {"com.apl.lms.common.lib.feign"})
@EnableDiscoveryClient
public class LmsCommonQueryApplication {

    public static void main(String[] args) {


        SpringApplication.run(LmsCommonQueryApplication.class , args);
    }


}
