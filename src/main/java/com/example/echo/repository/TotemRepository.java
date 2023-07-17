package com.example.echo.repository;

import com.example.echo.model.Totem;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TotemRepository {
    private static final Map<Integer, Totem> totens = new HashMap<>();
    private int lastId = 0;

    public Totem salvarTotem(Totem totem){
        lastId = lastId + 1;
        totem.setId(lastId);
        totens.put(lastId, totem);
        return  totem;
    }
    public Totem findByTranca(int idTranca) {
        Optional<Totem> totemRecuperado = totens.values().stream().filter(totem -> totem.getTrancas().stream().anyMatch(tranca -> tranca.getId() == idTranca)).findFirst();

        return totemRecuperado.orElse(null);
    }
    public Totem alterarTotem(Totem totem, int id){
        totem.setId(id);
        totens.put(id, totem);
        return totem;
    }

    public void deleteTotem(int idTotem) {
        totens.remove(idTotem);
    }

    public Totem findById(int idTotem){
        return totens.get(idTotem);
    }

    public List<Totem> findAll(){
        return new ArrayList<>(totens.values());
    }
}
