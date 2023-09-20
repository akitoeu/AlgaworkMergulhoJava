package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;
import com.algaworks.banco.modelo.pagamento.Holerite;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Akira");
        titular1.setDocumento(111_111_111);

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Theo");  // existe diferanca na execucao com esta variavel null
                                // por conta do construtor em Conta
        titular2.setDocumento(222_222_222);

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento contaAkira = new ContaInvestimento(titular1,123,11111);
        //Conta contaAdriana = new Conta(titular1,123,11111);

        ContaEspecial contaTheo = new ContaEspecial(titular2,124,22222, 1_000);




        try {
            contaAkira.depositar(6_000);
            contaAkira.debitarTarifaMensal();


            contaTheo.depositar(17_000);
            contaTheo.sacar(16_000);
            contaTheo.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular1, 1_000);
            Holerite salarioFuncionario = new Holerite(titular1, 100, 60);

            caixaEletronico.imprirmirSaldo(contaAkira);
            System.out.println();
            System.out.println("Boleto pago: " + boletoEscola.estaPago());
            caixaEletronico.pagar(boletoEscola, contaAkira);
            boletoEscola.imprimirRecibo();
            System.out.println("Boleto pago: " + boletoEscola.estaPago());

            caixaEletronico.imprirmirSaldo(contaAkira);
            System.out.println();
            System.out.println("Salario pago: " + salarioFuncionario.estaPago());
            caixaEletronico.pagar(salarioFuncionario, contaAkira);
            salarioFuncionario.imprimirRecibo();
            System.out.println("Salario pago: " + salarioFuncionario.estaPago());
        } catch (IllegalStateException e){
            System.out.println("Erro ao executar operação na conta: "+ e.getMessage());
        };
        caixaEletronico.imprirmirSaldo(contaAkira);
        System.out.println();
        caixaEletronico.imprirmirSaldo(contaTheo);

    }
}
