package com.PIV.apiac.controllers;

import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {
    @Autowired
    EventoService eventoService;
    @GetMapping
    public ResponseEntity<List<Evento>> findAll(){
        List<Evento> list = eventoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Evento> findById(@PathVariable Long id){
        Evento obj = eventoService.finfById(id);
        return ResponseEntity.ok().body(obj);
    }
}
