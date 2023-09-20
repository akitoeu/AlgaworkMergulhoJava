package com.algaworks.banco.modelo;

public class ContaEspecial extends Conta{
    private double valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numero, double valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    @Override
    public void debitarTarifaMensal() {
        sacar(20);
    }

    @Override
    public double getSaldoDisponivel() {
        return getSaldo() + getValorLimite();
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }



}
