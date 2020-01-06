package com.plf.student.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource){
        return Flyway.configure().dataSource(dataSource).locations("flyway").load();
    }
}
