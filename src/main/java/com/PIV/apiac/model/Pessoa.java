package com.PIV.apiac.model;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.domain.dtos.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pessoaId;
    private String nome;
    private String email;
    private String rg;
    private String cpf;
    @Lob
    private byte[] iFacial;
    @Lob
    private byte[] foto;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private LocalDateTime dataHoraXML;
    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    private List<Evento> eventos = new ArrayList<>();
    public List<Evento> getEventos() {
        return eventos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return pessoaId == pessoa.pessoaId;
    }

    public Pessoa(PessoaDTO obj) {
        this.pessoaId = obj.getPessoaId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.rg = obj.getRg();
        this.cpf = obj.getCpf();
        this.iFacial = obj.getIFacial();
        this.foto = obj.getFoto();
        this.categoria = obj.getCategoria();
        this.dataHoraXML = obj.getDataHoraXML();
        this.eventos = obj.getEventos();
    }
    @Override
    public int hashCode() {
        return Objects.hash(pessoaId);
    }
}
