package com.PIV.apiac.services;

import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {


    PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        List<Pessoa> list;
        list = pessoaRepository.findAll();
        return list;
    }
}
