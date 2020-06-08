package com.shiyanlou.springboot.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        // 设置 Repository 所在位置
        basePackages = {"com.shiyanlou.springboot.second"},
        // 设置 entityManager 工厂
        entityManagerFactoryRef = "entityManagerFactorySecond",
        // 设置事务管理器
        transactionManagerRef = "transactionManagerSecond")

public class SecondDataSourceConfiguration{
    /**
     * 数据源二
     */
    private final DataSource secondDataSource;

    /**
     * 构造方式注入依赖
     */
    @Autowired
    public SecondDataSourceConfiguration(@Qualifier("secondDataSource") DataSource secondDataSource){
        this.secondDataSource = secondDataSource;
    }

    /**
     * 配置 entityManager 工厂
     */
    @Bean(name = "entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder){
        return builder
                // 设置数据源
                .dataSource(secondDataSource)
                // 设置 entity 的包路径
                .packages("com.shiyanlou.springboot.second")
                .build();
    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManagerSecond")
    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }
}