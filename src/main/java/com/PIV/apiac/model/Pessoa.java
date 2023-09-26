package com.PIV.apiac.model;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.domain.Evento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity()
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pessoaId;
    private String nome;
    private String email;
    private String rg;
    private String cpf;
    private byte[] iFacial;
    private byte[] foto;
    @ManyToOne
    @JoinColumn(name = "Categoria")
    private Categoria categoriaId;
    private LocalDate dataHoraXML;
    @OneToMany(mappedBy = "pessoa")
    private List<Evento> eventos = new ArrayList<>();
    public List<Evento> getEventos() {
        return eventos;
    }


}
