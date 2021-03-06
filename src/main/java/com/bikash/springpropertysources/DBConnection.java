package com.bikash.springpropertysources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@Configuration
@PropertySource("dbconnection.properties")
@ConfigurationProperties(prefix = "db")
public class DBConnection {
    private String username;
    private String password;
}
