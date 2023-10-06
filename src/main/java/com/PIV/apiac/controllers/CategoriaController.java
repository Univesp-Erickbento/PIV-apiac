package com.PIV.apiac.controllers;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list;
        list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj =categoriaService.finfById(id);
        return ResponseEntity.ok().body(obj);
    }
}
