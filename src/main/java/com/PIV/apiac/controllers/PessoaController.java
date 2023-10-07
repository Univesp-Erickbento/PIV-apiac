package com.PIV.apiac.controllers;

import com.PIV.apiac.domain.dtos.PessoaDTO;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){

        List<Pessoa> list = new ArrayList<>();
        list = pessoaService.findAll();
        List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        Pessoa obj =pessoaService.finfById(id);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
    }

}
