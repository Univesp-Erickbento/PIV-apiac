package com.PIV.apiac.controllers;

import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.services.EventoService;
import com.PIV.apiac.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {
    @Autowired
    EventoService eventoService;
    @Autowired
    PessoaService pessoaService;
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

    @PostMapping(value = "/addevento")
    public ResponseEntity<String> addEvento(@RequestParam("pessoaid") Long pessoaId){ // função recebe somente o Id da pessoa a qual o evento pertencerá
        Pessoa pessoa = pessoaService.finfById(pessoaId);//  Uma instancia de pessoa com o ID passado é buscada no banco
        if (pessoa == null){
            return ResponseEntity.status(500).body("Pessoa com o id " + pessoaId + " não existe!"); // Se a pessoa é null significa que para aquele ID não existe pessoa
        }
        Evento evento = new Evento(null, Instant.now(), pessoa); // É criado um novo evento con horario de agora(Instant.now())
        eventoService.create(evento); // Evento serveice chamado para criar o novo evento no banco
        return ResponseEntity.ok().body("Salvo"); // uma resposta para dar ok
    }

}
