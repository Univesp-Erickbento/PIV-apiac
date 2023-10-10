package com.PIV.apiac.repositories;

import com.PIV.apiac.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
