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

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Override
    public void run(String... args) throws Exception {
        Categoria cat;
        cat = new Categoria(1L, "Morador", Duration.ofHours(365 * 24L));
        Categoria cat2 = new Categoria(2L, "Prestador", Duration.ofHours(24L));
        categoriaRepository.saveAll(Arrays.asList(cat, cat2));
        Pessoa p1 = new Pessoa(1L, "Kedes", "kedes@gmail.com", "436723342", "12345678900", null, null, cat, LocalDateTime.now(), null);
        //Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa(2L, "Erick", "erick@gmail.com", "436723342", "12345678900", null, null, cat2, LocalDateTime.now(), null);
        Pessoa p3 = new Pessoa();

        pessoaRepository.saveAll(Arrays.asList(p1, p2, p3));

        Evento evt1 = new Evento(1L, Instant.now(), p1);
        Evento evt2 = new Evento(2L, Instant.now().plusSeconds(30), p1);
        Evento evt3 = new Evento(3L, Instant.now().plusSeconds(60), p1);

        Evento evt4 = new Evento(4L, Instant.now().plusSeconds(10), p2);
        Evento evt5 = new Evento(5L, Instant.now().plusSeconds(20), p2);
        Evento evt6 = new Evento(6L, Instant.now().plusSeconds(40), p2);

        eventoRepository.saveAll(Arrays.asList(evt1, evt2, evt3, evt4, evt5, evt6));
    }
}
