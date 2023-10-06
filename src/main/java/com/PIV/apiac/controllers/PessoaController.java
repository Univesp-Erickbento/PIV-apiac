package com.PIV.apiac.controllers;

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

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){

        List<Pessoa> list = new ArrayList<>();
        list = pessoaService.findAll();

        return ResponseEntity.ok().body(list);

    }

}
