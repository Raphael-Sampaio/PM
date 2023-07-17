package com.example.echo.service;

import com.example.echo.model.Totem;
import com.example.echo.repository.TotemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TotemService {
    private final TotemRepository totemRepository;

    @Autowired
    public TotemService(TotemRepository totemRepository) {
        this.totemRepository = totemRepository;
    }

    public Totem cadastrarTotem(Totem totem) {
        if(totem.getTrancas() == null) {
            totem.setTrancas(new ArrayList<>());
        }
        return totemRepository.salvarTotem(totem);
    }

    public Totem recuperarTotem(int idTotem) {
        return totemRepository.findById(idTotem);
    }

    public Totem deletarTotem (int idTotem) {
        Totem totemRecuperado = totemRepository.findById(idTotem);
        if (totemRecuperado != null) {
            totemRepository.deleteTotem(idTotem);
            return totemRecuperado;
        }
        return null;
    }

    public Totem atualizarTotem(Totem totem, int id) {
        Totem totemRecuperado = totemRepository.findById(id);
        if (totemRecuperado != null) {
            return totemRepository.alterarTotem(totem, id);
        }
        return null;
    }

    public Totem recuperarTotemPorTranca(int idTranca) {
        return totemRepository.findByTranca(idTranca);
    }


    public List<Totem> recuperarTodosTotens() {
        return totemRepository.findAll();
    }
}
