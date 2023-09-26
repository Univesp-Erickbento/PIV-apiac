package com.PIV.apiac.model;

import com.PIV.apiac.domain.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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


}
