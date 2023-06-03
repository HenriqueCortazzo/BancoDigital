package bancodigital;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta c = null;
        Conta c1 = new ContaCorrente(new Cliente("Jorge", "123456788-22"));

        System.out.println("Banco XXL");
        System.out.println("Criacao de Conta");
        System.out.print("Digite o seu nome:\n");

        String nome = ler.nextLine();
        System.out.print("Digite o seu CPF:\n");

        String CPF = ler.nextLine();
        Cliente cliente = new Cliente(nome, CPF);

        System.out.println("Digite 1 para criar uma conta corrente ou");
        System.out.print("Digite 2 para criar uma conta poupanca:");

        switch (ler.nextInt()) {
            case 1:
                c = new ContaCorrente(cliente);
                System.out.println("\nO que você deseja?");
                break;
            case 2:
                c = new ContaPoupanca(cliente);
                System.out.println("\nO que você deseja?");
        }

    }
}
