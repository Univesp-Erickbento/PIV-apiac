package com.PIV.apiac.config;

import com.PIV.apiac.services.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@Profile("dev")
public class DevConfig  {
  private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

//    @Bean
//    public boolean instanciaDB() {
//        if(value.equals("create")) {
//            this.dbService.();
//        }
//        return false;
//    }
}

