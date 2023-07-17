package com.example.echo.service;

import com.example.echo.model.RedeTotem;
import com.example.echo.repository.RedeTotensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedeTotensService {
    private final RedeTotensRepository redeTotensRepository;

    @Autowired
    public RedeTotensService(RedeTotensRepository redeTotensRepository) {
        this.redeTotensRepository = redeTotensRepository;
    }

    public RedeTotem cadastrarRedeTotens(RedeTotem redeTotem) {
        return redeTotensRepository.salvarRedeTotens(redeTotem);
    }

    public RedeTotem recuperarRedeTotens(int idRedeTotens) {
        return redeTotensRepository.findById(idRedeTotens);
    }

    public RedeTotem recuperarRedeTotensPorTranca(int idTranca) {
        return redeTotensRepository.findByTranca(idTranca);
    }

    public RedeTotem atualizarRedeTotens(RedeTotem redeTotem, int id) {
        RedeTotem redeTotemRecuperado = redeTotensRepository.findById(id);
        if (redeTotemRecuperado != null) {
            return redeTotensRepository.alterarRedeTotens(redeTotem, id);
        }
        return null;
    }

    public RedeTotem deletarRedeTotens (int idRedeTotens) {
        RedeTotem redeTotemRecuperado = redeTotensRepository.findById(idRedeTotens);
        if (redeTotemRecuperado != null) {
            redeTotensRepository.deleteRedeTotens(idRedeTotens);
            return redeTotemRecuperado;
        }
        return null;
    }

    public List<RedeTotem> recuperarTodosTotens() {
        return redeTotensRepository.findAll();
    }
}

