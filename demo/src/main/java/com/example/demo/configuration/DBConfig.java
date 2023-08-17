package com.example.demo.configuration;

import javax.sql.DataSource;

//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 * Flexible Initialisierung fuer Datenbank i. A. der Umgebung (dev,prod)
 */

@Configuration
@Component
public class DBConfig {
	
	//@ConfigurationProperties(prefix = "datasource.postgres") // if taken from file
    @Bean
    @Primary
    public DataSource getDataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:postgresql://localhost:5432/feeding_monitor")
                .username("postgres")
                .password("postgres")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

}
