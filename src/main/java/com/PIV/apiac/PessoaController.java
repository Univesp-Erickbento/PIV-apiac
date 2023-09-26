package com.PIV.apiac;

import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

//    @Autowired
//    private ClienteUserCase clienteUserCase;

    @Autowired
    PessoaRepository pessoaRepository;
//
//    @PostMapping("/funcionario")
//    public ResponseEntity<Pessoa> savePessoa (@RequestBody @Valid FuncionarioRecordDto funcionarioRecordDto) {
//        var funcionario = new Funcionarios();
//        BeanUtils.copyProperties(funcionarioRecordDto, funcionario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioRepository.save(funcionario));
  //  }
//    @GetMapping
//    public List<ClienteDTO> findAll(){
//        List<ClienteDTO> result = clienteUserCase.findAll();
//        // List<Cliente> dto = result.stream().map(cliente -> new Cliente(cliente)).toList();
//        return result;
//    }

}
