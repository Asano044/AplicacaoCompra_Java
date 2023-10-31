package compras;

import modelo.CartaoCredito;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Compras {
    public static void main(String[]args) {
//        Declarando as variáveis que serão usadas
        Scanner entrada = new Scanner(System.in);
        String nomeCompra;
        double valorCompra;
        int resposta = 1;

        System.out.println("Insira o valor do cartão de crédito: ");
        CartaoCredito saldoCartao = new CartaoCredito(entrada.nextDouble());

//        Criando o dicionário de compras
        Map<String, Double> dicionarioCompras = new HashMap<>();

//        Criando loop para preencher o dicionário
        while (resposta == 1) {
//            Preenchendo dicionário com os valores informados
            System.out.println("Digite a descrição da compra: ");
            nomeCompra = entrada.next();
            System.out.println("Informe o valor da compra: ");
            valorCompra = entrada.nextDouble();

            if (valorCompra >= 0 && valorCompra < saldoCartao.getCartaoCredito()) {
                saldoCartao.setCartaoCredito(saldoCartao.getCartaoCredito() - valorCompra);
            } else if (valorCompra < 0) {
                System.out.println("Impossível informar valor negativo.\n");
                break;
            } else if (valorCompra > saldoCartao.getCartaoCredito()) {
                System.out.println("O valor deste item é maior que o orçamento.\n");
                break;
            }

            dicionarioCompras.put(nomeCompra, valorCompra);

//            Perguntando se o usuário deseja continuar
            System.out.println("Digite 0 caso deseje sair ou 1 para continuar.");
            resposta = entrada.nextInt();
        }

        String menuAbertura = """
                *************************
                COMPRAS REALIZADAS:
                """;
        System.out.println(menuAbertura);
        for (String chave : dicionarioCompras.keySet()) {
            System.out.println(chave + " - " + dicionarioCompras.get(chave));
        }

        String menuEncerramento = """
                
                *************************
                """;
        System.out.println(menuEncerramento);
        System.out.println("Saldo do cartão: " + saldoCartao.getCartaoCredito());
    }
}
