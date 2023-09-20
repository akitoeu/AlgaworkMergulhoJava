package com.algaworks.banco.modelo;

import java.util.Objects;

public abstract class Conta {
    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    public Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular.getNome());
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public Conta(Pessoa titular){
        Objects.requireNonNull(titular.getNome());
        this.titular = titular;
    }

    Conta(){
        Objects.requireNonNull(titular.getNome());
    }

    public void depositar(double valor){
        if (valor <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que ZERO");
        }
        saldo=saldo+valor;
    }

    public void sacar(double valor){

        if (valor <= 0 ){
            throw new IllegalArgumentException("Valor deve ser maior que ZERO");
        }

        if (getSaldoDisponivel() - valor < 0 ){
            throw new IllegalStateException("Saldo Insuficiente");
        }
        saldo=saldo-valor;
    }

    public void sacar(double valor, double taxaSaque){
        sacar(valor+taxaSaque);
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel(){
       return getSaldo();
    }

}
