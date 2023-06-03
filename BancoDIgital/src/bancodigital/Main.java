package bancodigital;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta userClient = null;
        Conta c1 = new ContaPoupanca(new Cliente("Jorge", "123456788-22"));

        JOptionPane.showMessageDialog(null, "               Seja Bem Vindo ao Banco Vang! \n Estamos inicializando o sistema em seu Terminal. \n                           Por favor aguarde.\n");

        System.out.println("Olá, seja Bem Vindo! \nEstavámos esperando por você!\n");

        System.out.println("Criação de Conta");
        System.out.print("Digite o seu nome:\n");

        String nome = ler.nextLine();
        System.out.print("Digite o seu CPF:\n");

        String CPF = ler.nextLine();
        Cliente cliente = new Cliente(nome, CPF);

        System.out.println("Digite 1 para criar uma conta corrente ou");
        System.out.print("Digite 2 para criar uma conta poupanca:");

        switch (ler.nextInt()) {
            case 1:
                userClient = new ContaCorrente(cliente);
                System.out.println("\nVocê selecionou a opção de Conta Corrente.");
                System.out.println("Estamos Inicializando o Sistema.");
                System.out.println("Por favor, aguarde.");
                break;
            case 2:
                userClient = new ContaPoupanca(cliente);
                System.out.println("\nVocê selecionou a opção de Conta Poupança.");
                System.out.println("Estamos Inicializando o Sistema.");
                System.out.println("Por favor, aguarde.");
        }

        for (int i = 0; i != 5;) {
            System.out.println();
            System.out.println("O que você deseja?");
            System.out.println("Selecione um número");
            System.out.println("1-Depositar \n2-Sacar \n3-Transferir \n4-Extrato \n5-Encerrar atividade");
            int acaoCliente = ler.nextInt();
            i = acaoCliente;
            switch (acaoCliente) {
                case 1:
                    System.out.print("Digite o valor do deposito:");
                    userClient.depositar(ler.nextDouble());
                    System.out.println("Saldo: R$" + userClient.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do saque:");
                    Double valorSaque = ler.nextDouble();
                    if (valorSaque > userClient.getSaldo()) {

                        System.out.println("Saldo insuficiente!" + "\n Saldo atual: "
                                + userClient.getSaldo() + "\n Valor do saque: " + valorSaque);
                    } else {

                        Double temp1 = userClient.getSaldo();
                        userClient.sacar(valorSaque);
                        System.out.println("Saldo Antigo: R$" + temp1 + "\n Saldo Atual: R$"
                                + userClient.getSaldo());
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor da transferência para " + c1.getCliente());
                    userClient.transferir(ler.nextDouble(), c1);
                    System.out.println("Transação concluida!");
                    break;
                case 4:
                    userClient.imprimirExtrato();
                    break;
                case 5:
                    userClient.imprimirExtrato();
                    break;
            }

        }
    }
}
