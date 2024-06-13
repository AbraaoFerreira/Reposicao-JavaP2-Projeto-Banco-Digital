import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaBancoUniesp {
    public static void main(String[] args) {
        Map<Integer, Conta> contas = new HashMap<>();
        contas.put(1, new ContaCorrente(1, "Abraao", 1000.0));
        contas.put(2, new ContaPoupanca(2, "Ferreira", 500.0));

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    consultarSaldo(contas, scanner);
                    break;
                case 2:
                    depositar(contas, scanner);
                    break;
                case 3:
                    sacar(contas, scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nOpções:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void consultarSaldo(Map<Integer, Conta> contas, Scanner scanner) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            System.out.println("Saldo da conta de " + conta.consultarSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void depositar(Map<Integer, Conta> contas, Scanner scanner) {
        System.out.print("Número da conta para depósito: ");
        int numContaDeposito = scanner.nextInt();
        System.out.print("Valor a depositar: ");
        double valorDeposito = scanner.nextDouble();
        contas.get(numContaDeposito).depositar(valorDeposito);
        System.out.println("Depósito realizado com sucesso.");
    }

    private static void sacar(Map<Integer, Conta> contas, Scanner scanner) {
        System.out.print("Número da conta para saque: ");
        int numContaSaque = scanner.nextInt();
        System.out.print("Valor a sacar: ");
        double valorSaque = scanner.nextDouble();
        boolean saqueEfetuado = contas.get(numContaSaque).sacar(valorSaque);
        if (saqueEfetuado) {
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
