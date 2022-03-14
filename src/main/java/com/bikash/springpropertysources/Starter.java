package com.bikash.springpropertysources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@PropertySource("config.properties")
public class Starter implements CommandLineRunner {
    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    private DBConnection dbConnection;

    @Override
    public void run(String... args) throws Exception {
        this.readApplicationProperties();
        this.readConfigProperties();
        this.readDBConnectionProperties();
    }
    public void readApplicationProperties(){
        log.info("======Application Properties======");
        log.info("App name: {} ,App version: {}",appName,appVersion);
    }
    public void readConfigProperties(){
        log.info("======Config Properties======");
        log.info("Admin username: {},Admin Password: {}",adminUsername,adminPassword);
        ;
    }
    public void readDBConnectionProperties(){
        log.info("======Database Connection Properties");
        log.info("Database username: {}, Database password: {}",dbConnection.getUsername(),dbConnection.getPassword());
    }


}
