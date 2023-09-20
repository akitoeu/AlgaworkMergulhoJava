package com.algaworks.banco.modelo;

import java.util.Objects;

public class Pessoa {
    private String nome;
    int documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
}
