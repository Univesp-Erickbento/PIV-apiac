package com.PIV.apiac.config;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.repositories.CategoriaRepository;
import com.PIV.apiac.repositories.EventoRepository;
import com.PIV.apiac.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevConfig  {
//    @Autowired
//    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

//    @Bean
//    public boolean instanciaDB() {
//        if(value.equals("create")) {
//            this.dbService.instanciaDB();
//        }
//        return false;
//    }
}

