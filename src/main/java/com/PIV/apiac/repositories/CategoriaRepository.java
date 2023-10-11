package com.PIV.apiac.repositories;

import com.PIV.apiac.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria getByNomeCategoria(String nomeCategoria);
}
