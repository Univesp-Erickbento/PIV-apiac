package com.PIV.apiac.controllers;

import com.PIV.apiac.domain.Categoria;
import com.PIV.apiac.domain.dtos.PessoaDTO;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.services.CategoriaService;
import com.PIV.apiac.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    CategoriaService categoriaService;
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
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO objDTO) {
        Pessoa newObj = pessoaService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getPessoaId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PostMapping(value = "/addpessoa")
            public ResponseEntity<String> addPessoa(@RequestParam("nome") String nome,
                                                    @RequestParam("email") String email,
                                                    @RequestParam("rg") String rg,
                                                    @RequestParam("cpf") String cpf,
                                                    @RequestParam("ifacial") MultipartFile iFacial,
                                                    @RequestParam("foto") MultipartFile foto,
                                                    @RequestParam("categoria") String nomeCategoria){
        //Categoria categoria = categoriaService.findById(1L);
        Categoria categoria = categoriaService.findByNomeCategoria(nomeCategoria);
        if (categoria == null){
            return ResponseEntity.status(500).body("Categoria Inesistente");
        }
        try {
            byte[] bytesIFacial = iFacial.getBytes();
            byte[] bytesFoto = foto.getBytes();

            Pessoa novapessoa = new Pessoa(null, nome, email, rg, cpf, bytesIFacial, bytesFoto, categoria, LocalDateTime.now(), null);
            PessoaDTO novaPessoaDTO = new PessoaDTO(novapessoa);
            pessoaService.create(novaPessoaDTO);
            return ResponseEntity.ok().body("Salvo");

        }
        catch(IOException e){
            return ResponseEntity.status(500).body("Falha ao processar o arquivo.");
        }

    }

}
