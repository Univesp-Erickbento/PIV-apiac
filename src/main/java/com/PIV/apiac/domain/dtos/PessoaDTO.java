package com.PIV.apiac.domain.dtos;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.model.Pessoa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class PessoaDTO implements Serializable {
    private static final Long serialVesionUID =1l;

    private Long pessoaId;
    private String nome;
    private String email;
    private String rg;
    private String cpf;
    private byte[] iFacial;
    private byte[] foto;
    private Categoria categoria;
    private LocalDateTime dataHoraXML;
    private List<Evento> eventos = new ArrayList<>();
    public List<Evento> getEventos() {
        return eventos;
    }

    public PessoaDTO(Pessoa obj) {
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
}
