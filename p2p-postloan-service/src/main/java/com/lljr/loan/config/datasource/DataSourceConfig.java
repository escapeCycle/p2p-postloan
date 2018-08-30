package com.lljr.loan.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author tianhuan
 * @date 2018-08-30 17:37
 **/
@Configuration
@Slf4j
public class DataSourceConfig {
    @Bean(name = "thOne")
    @ConfigurationProperties(prefix = "spring.datasource.thOne") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        log.info("-------------------- thOne init ---------------------");
        return DataSourceBuilder.create().build();
    }




    @Bean(name = "thTwo")
    @ConfigurationProperties(prefix = "spring.datasource.thTwo") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        log.info("-------------------- thTwo init ---------------------");
        return DataSourceBuilder.create().build();
    }
}
