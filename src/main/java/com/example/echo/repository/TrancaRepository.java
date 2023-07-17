package com.example.echo.repository;

import com.example.echo.model.Tranca;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TrancaRepository {
    private static final Map<Integer, Tranca> trancas = new HashMap<>();
    private  int lastId = 0;

    public Tranca salvarTranca(Tranca tranca){
        lastId = lastId + 1;
        tranca.setId(lastId);
        trancas.put(lastId, tranca);
        return  tranca;
    }

    public Tranca alterarTranca(Tranca tranca,int id){
        tranca.setId(id);
        trancas.put(id, tranca);
        return tranca;
    }

    public void deleteTranca(int idTranca) {
        trancas.remove(idTranca);
    }

    public Tranca findById(int idTranca){
        return trancas.get(idTranca);
    }

    public List<Tranca> findAll(){
        return trancas.values().stream().collect(Collectors.toList());
    }
}
