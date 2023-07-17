package com.example.echo.repository;

import com.example.echo.model.RedeTotem;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RedeTotensRepository {
    private static final Map<Integer, RedeTotem> redes = new HashMap<>();

    public RedeTotem salvarRedeTotens(RedeTotem redeTotem){
        redeTotem.setId(redeTotem.getTotem().getId());
        redes.put(redeTotem.getTotem().getId(), redeTotem);
        return redeTotem;
    }

    public RedeTotem alterarRedeTotens(RedeTotem redeTotem, int id){
        redeTotem.setId(id);
        redes.put(id, redeTotem);
        return redeTotem;
    }

    public void deleteRedeTotens(int idRedeTotens) {
        redes.remove(idRedeTotens);
    }

    public RedeTotem findById(int idRedeTotem){
        return redes.get(idRedeTotem);
    }

    public RedeTotem findByTranca(int idTranca) {
        Optional<RedeTotem> rede = redes.values().stream().filter(redeTotem -> redeTotem.getTrancas().stream().anyMatch(tranca -> tranca.getId() == idTranca)).findFirst();

        if(rede.isPresent()) {
            return rede.get();
        }
        return null;
    }

    public List<RedeTotem> findAll(){
        return redes.values().stream().collect(Collectors.toList());
    }
}