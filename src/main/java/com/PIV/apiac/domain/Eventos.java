package com.PIV.apiac.domain;

import com.PIV.apiac.model.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity()
public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoId;
    private LocalDateTime momento;
    @ManyToOne
    @JoinColumn(name = "Pessoa")
    private Pessoa pessoaId;


}
