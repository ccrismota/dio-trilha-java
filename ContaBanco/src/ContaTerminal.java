import java.util.Scanner;

import agencia.Conta;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in).useLocale(java.util.Locale.US);

        Conta conta = new Conta(0125, "2584-8", "Lucas", 1000.00);

        int continuar = 1;
        while (continuar != 0) {

            System.out.println("------------------------------------------------------------");
            System.out.println("Por favor, digite o número da operação que deseja realizar!|");
            System.out.println("0 - Sair                                                   |");
            System.out.println("1 - Abrir Conta                                            |");
            System.out.println("2 - Depósito                                               |");
            System.out.println("3 - Saque                                                  |");
            System.out.println("4 - Transferência                                          |");
            System.out.println("5 - Saldo                                                  |");
            System.out.println("6 - Extrato                                                |");
            System.out.println("------------------------------------------------------------");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 0: {
                    System.out.println("Obrigado por utilizar nossos serviços! Até a próxima!       |");
                    System.out.println();
                    continuar = 0;
                    break;
                }
                case 1: {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você digitou a opção 1 - Abrir Conta !                     |");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o nome do cliente !                      |");
                    conta.setNomeCliente(sc.nextLine());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o número da Agência !                    |");
                    conta.setAgencia(sc.nextLine());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o número da Conta !                      |");
                    conta.setNumero(sc.nextInt());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o valor do depósito!            |");
                    conta.setSaldo(sc.nextDouble());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Olá " + conta.getNomeCliente()
                            + " obrigado por criar uma conta em nosso banco," + "\n"
                            + "sua agência é " + conta.getAgencia() + ", conta " + conta.getNumero() + " e seu saldo "
                            + conta.getSaldo() + " já está" + "\n" + "disponível para saque.");
                    break;
                }
                case 2: {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você digitou a opção 2 - Depósito !                        |");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o valor do depósito!                     |");
                    conta.depositar(sc.nextDouble());
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 3: {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você digitou a opção 2 - Saque !                           |");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o valor do saque !                       |");
                    conta.sacar(sc.nextDouble());
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 4: {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Você digitou a opção 3 -Transferência                      |");
                    System.out.println("------------------------------------------------------------");

                    Conta contaDestino = new Conta(012145, "2584-8", "Lucas", 1000.00);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o nome do cliente que receberá o valor!  |");
                    contaDestino.setNomeCliente(sc.nextLine());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o número da agência  de transferencia!   |");
                    contaDestino.setAgencia(sc.nextLine());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o número da Conta de transferencia!      |");
                    contaDestino.setNumero(sc.nextInt());
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Por favor, digite o valor da transferência !");
                    conta.transferir(contaDestino, sc.nextDouble());
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 5: {
                    System.out.println(conta.toString());
                    break;
                }
                case 6: {
                    conta.extrato();
                    break;
                }
                default:
                    System.out.println("Operação inválida");
                    break;
            }
            
            if (continuar != 0) {
                System.out.println("Deseja realizar outra operação? 1 - Sim | 0 - Não          |");
                continuar = sc.nextInt();
                if (continuar == 0) {
                    System.out.println("Obrigado por utilizar nossos serviços! Até a próxima!      |");
                    System.out.println();
                }
            } else {
                System.out.println("Informe uma opção válida! 1(um) ou 0 (zero)                |");
                continuar = sc.nextInt();
            }
        }
        sc.close();
    }
}
