package com.lance.rear.stepcounter.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceBean {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:stepcounter");
        dataSourceBuilder.username("sc_admin");
        dataSourceBuilder.password("sc_admin_password");
        return dataSourceBuilder.build();
    }
}
