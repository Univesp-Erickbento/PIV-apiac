package com.PIV.apiac.services;

import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.repositories.PessoaRepository;
import com.PIV.apiac.services.exceptions.ObjectnotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        List<Pessoa> list;
        list = pessoaRepository.findAll();
        return list;
    }

    public Pessoa finfById(Long id){
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundExeption("Objeto não encontrado! Id: " + id));
    }

}
