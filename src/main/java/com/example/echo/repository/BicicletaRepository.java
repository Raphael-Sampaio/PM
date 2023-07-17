package com.example.echo.repository;

import com.example.echo.model.Bicicleta;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BicicletaRepository {
    private static final Map<Integer, Bicicleta> bikes = new HashMap<>();
    private  int lastId = 0;

    public Bicicleta salvarBicicleta(Bicicleta bicicleta){
        lastId = lastId + 1;
        bicicleta.setId(lastId);
        bikes.put(lastId, bicicleta);
        return  bicicleta;
    }

    public Bicicleta alterarBicicleta(Bicicleta bicicleta ,int id){
        bicicleta.setId(id);
        bikes.put(id, bicicleta);
        return bicicleta;
    }

    public void deleteBicicleta(int idBicicleta) {
        bikes.remove(idBicicleta);
    }

    public Bicicleta findById(int idBicicleta){
        return bikes.get(idBicicleta);
    }

    public List<Bicicleta> findAll(){
        return bikes.values().stream().collect(Collectors.toList());
    }
}