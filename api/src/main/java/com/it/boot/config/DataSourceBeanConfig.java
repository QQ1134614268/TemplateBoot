package com.it.boot.config;

import org.springframework.context.annotation.Configuration;

//DataSource
@Configuration
public class DataSourceBeanConfig {
    // @Bean(name = "datasource1")
    // @Profile("test")
    // public DataSource testDataSource(Environment env) {
    //
    //     return null;
    // }
    //
    // @Bean(name = "datasource1")
    // @Profile("prod") // @Profile({"test","!prod"})
    // public DataSource prodDataSource(Environment env) {
    //
    //     return null;
    // }
    //
    // @Bean
    // @Primary
    // @ConfigurationProperties(prefix = "spring.datasource")
    // public DataSource dataSource() {
    //     DataSource primary = DataSourceBuilder.create().build();
    //     return primary;
    // }
    //
    // @Bean(name = "readDataSource")
    // @ConfigurationProperties(prefix = "spring.datasource.read")
    // public DataSource readDataSource() {
    //     DataSource read = DataSourceBuilder.create().build();
    //     return read;
    // }
}
