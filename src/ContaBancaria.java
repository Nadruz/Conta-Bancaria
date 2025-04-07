public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private boolean usandoChequeEspecial;
    public String consultarChequeEspecial;

    public ContaBancaria(double depositarSaldo) {
        this.saldo = depositarSaldo;
        if(depositarSaldo <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = depositarSaldo * 0.5;
        } 
        this.usandoChequeEspecial = false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return chequeEspecial;
    }

    public void depositar(double valor){
        saldo += valor;
        if(usandoChequeEspecial && saldo >= 0) {
            double taxa = chequeEspecial * 0.2;
            saldo -= taxa;
            usandoChequeEspecial = false;
            System.out.println("Taxa de uso do cheque especial é de R$: " + taxa);
        }
    }

    public void sacar(double valor) {
        if(saldo >= valor) {
            saldo -= valor;
        } else if(saldo + chequeEspecial >= valor) {
            usandoChequeEspecial = true;
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecial -= restante; 
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    public void pagarBoleto(double valor) {
        sacar(valor);
    }

    public boolean verificarChequeEspecial() {
        return usandoChequeEspecial;
    }

    }

