package com.shiyanlou.springboot;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 */
@Configuration
public class DataSourceConfig{

    @Bean
    @Primary // 该注解表示为主数据源
    @ConfigurationProperties("app.datasource.first") // 读取前缀为 app.datasource.first 的属性
    public DataSourceProperties firstDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.first")
    public DataSource firstDataSource(){
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean // 这是第二个数据源，不能加 @Primary 注解了
    @ConfigurationProperties("app.datasource.second")
    public DataSourceProperties secondDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("app.datasource.second")
    public DataSource secondDataSource(){
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }
}