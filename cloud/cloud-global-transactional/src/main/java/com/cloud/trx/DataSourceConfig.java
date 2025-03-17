package com.cloud.trx;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 如果你使用 Druid
        // return new DruidDataSource();

        // 如果你使用默认的 HikariCP
        return new HikariDataSource();
    }

    @Primary
    @Bean("dataSourceProxy")
    public DataSource dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }
}