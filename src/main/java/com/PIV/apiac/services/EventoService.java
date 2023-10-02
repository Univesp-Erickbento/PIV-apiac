package com.PIV.apiac.services;

import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public List<Evento> findAll(){
        List<Evento> list = eventoRepository.findAll();
        return list;
    }

}
