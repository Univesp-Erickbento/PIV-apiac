package com.PIV.apiac.services;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){

        List<Categoria> list;
        list = categoriaRepository.findAll();
        return list;
    }
    public Categoria finfById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.get();
    }
}
