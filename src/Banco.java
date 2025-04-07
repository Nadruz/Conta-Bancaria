import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("INSIRA O SALDO INICIAL: ");

    double saldoInicial = scanner.nextDouble();
    ContaBancaria conta = new ContaBancaria(saldoInicial);

    int opcao;
    do {
        System.out.println("\nMenu Interativo");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Consultar cheque especial");
        System.out.println("3. Depositar dinheiro");
        System.out.println("4. Sacar dinheiro");
        System.out.println("5. Pagar um boleto");
        System.out.println("6. Verificar se a conta está utilizando o cheque especial");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");

        opcao = scanner.nextInt();

        switch(opcao) {
            case 1: 
                System.out.println("Saldo: " + conta.consultarSaldo());
                break;
            
            case 2:
                System.out.println("Cheque especial: " + conta.consultarChequeEspecial());
                break;
            
            case 3:
                System.out.println("Valor do depósito: ");
                double deposito = scanner.nextDouble();
                break;
            
            case 4: 
                System.out.println("Valor do saque: ");
                double saque = scanner.nextDouble();
                break;

            case 5:
                System.out.println("Valor do boleto: ");
                double boleto = scanner.nextDouble(); 
                conta.pagarBoleto(boleto);
                break;
            
            case 6:
                System.out.println("Utilizando cheque especial: " + (conta.verificarChequeEspecial() ?  "sim" : "não"));
                break;

            case 0: 
                System.out.println("Encerrando o programa... ");
                break;
            }   
        } while (opcao != 0);

        scanner.close();
    }
}
