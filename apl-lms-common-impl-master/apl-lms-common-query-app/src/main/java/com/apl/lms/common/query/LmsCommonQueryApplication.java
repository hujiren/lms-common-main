package com.apl.lms.common.query;

import com.apl.tenant.AplTenantConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {
                "com.apl.lib", //APL基本工具类
                //"com.apl.tenant", //多租户
                "com.apl.db.adb", // adb数据库操作助手
                "com.apl.cache", // redis代理
                "com.apl.lms.common"},
        exclude = {AplTenantConfig.class})
@MapperScan(basePackages = {"com.apl.lms.common.mapper"})
@EnableSwagger2
@EnableDiscoveryClient
public class LmsCommonQueryApplication {

    public static void main(String[] args) {


        SpringApplication.run(LmsCommonQueryApplication.class , args);
    }


    @Primary
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }


}
