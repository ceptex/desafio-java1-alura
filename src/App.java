import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner leitura = new Scanner(System.in)) {
            System.out.println("Digite o nome completo do cliente:");
            String nomeCliente = leitura.nextLine();
            System.out.println("Digite o tipo de Conta:");
            String tipoConta = leitura.nextLine();
            System.out.println("Digite o saldo inicial: ");
            double saldo = leitura.nextDouble();

            System.out.println(String.format("""
                        ************************************

                        Dados do Cliente:

                        Nome:           %s
                        Tipo de conta:  %s
                        Saldo inicial:  R$ %,.2f
                        
                        ************************************
                    """, nomeCliente, tipoConta, saldo));

            String menu = """

                    Operações

                    1 - Consultar saldo
                    2 - Fazer depósito
                    3 - Fazer transferência
                    4 - Sair
                    """;
            System.out.println("Digite a operação desejada:");
            int operacao = 0;

            while (operacao != 4) {
                System.out.println(menu);
                operacao = leitura.nextInt();
                if (operacao == 1) {
                    System.out.println("Seu saldo é de: R$ " + saldo);
                } else if (operacao == 2) {
                    System.out.println("Digite o valor que deseja depositar: ");
                    double valor = leitura.nextDouble();
                    saldo += valor;
                    System.out.println("\nSeu saldo agora é de: R$ " + saldo);
                } else if (operacao == 3) {
                    System.out.println("Digite o valor que deseja transferir: ");
                    double valor = leitura.nextDouble();
                    if (valor > saldo) {
                        System.out.println("\nSaldo insuficiente para realizar operação.");
                    } else {
                        saldo -= valor;
                        System.out.println("\nSeu saldo agora é de: R$ " + saldo);
                    }
                } else if (operacao != 4) {
                    System.out.println("\nOpção inválida. Por favor, escolha outra operação.");
                }
            }
        }
    }
}
