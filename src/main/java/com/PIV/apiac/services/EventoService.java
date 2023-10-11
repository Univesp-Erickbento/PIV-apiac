package com.PIV.apiac.services;

import com.PIV.apiac.domain.Evento;
import com.PIV.apiac.model.Pessoa;
import com.PIV.apiac.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public List<Evento> findAll(){
        List<Evento> list = eventoRepository.findAll();
        return list;
    }
    public Evento finfById(Long id) {
        Optional<Evento> obj = eventoRepository.findById(id);
        return obj.get();
    }
    public Evento create(Evento evento){
        evento.setEventoId(null);
        return eventoRepository.save(evento);
    }
}
