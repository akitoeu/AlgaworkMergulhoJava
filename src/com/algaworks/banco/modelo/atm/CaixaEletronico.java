package com.algaworks.banco.modelo.atm;

import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.pagamento.DocumentoEstornavel;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {
    public void imprirmirSaldo(Conta conta){
        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());

    }

    public void pagar (DocumentoPagavel documento, Conta conta){
        if (documento.estaPago()){
            throw new IllegalStateException("Documento ja esta pago");
        }
        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();
    }

    public void estornarPagamento(DocumentoEstornavel documento, Conta conta){
        if (!documento.estaPago()) {
            throw new IllegalStateException("Documento não esta pago");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();

    }
}
