package com.example.echo.controller.body;

public class CadastroTrancaRede {
    int idTotem;
    int idTranca;
    int idFuncionario;

    public String getStatusAcaoReparador() {
        return statusAcaoReparador;
    }

    public void setStatusAcaoReparador(String statusAcaoReparador) {
        this.statusAcaoReparador = statusAcaoReparador;
    }

    String statusAcaoReparador;

    public int getIdTotem() {
        return idTotem;
    }

    public void setIdTotem(int idTotem) {
        this.idTotem = idTotem;
    }

    public int getIdTranca() {
        return idTranca;
    }

    public void setIdTranca(int idTranca) {
        this.idTranca = idTranca;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
