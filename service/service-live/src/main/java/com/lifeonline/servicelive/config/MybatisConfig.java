package com.lifeonline.servicelive.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.lifeonline.servicelive.mapper")
public class MybatisConfig {

//    @Bean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }

//    @Bean
//    public PaginationInnerInterceptor paginationInterceptor() {
//        return new PaginationInnerInterceptor();
//    }

}
