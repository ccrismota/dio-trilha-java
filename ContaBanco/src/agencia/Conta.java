package agencia;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    // #region getters and setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    // #endregion getters and setters

    public Conta(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "------------------------------------------------------------\n" +
                "Saldo Atual:\n" +
                "------------------------------------------------------------\n" +
                "Número da Conta: " + numero + "\n" +
                "Agência: " + agencia + "\n" +
                "Nome do Cliente: " + nomeCliente + "\n" +
                "Saldo: " + String.format("%.2f", saldo) + "\n" +
                "data: " + java.time.LocalDateTime.now().format(formatter) + "\n" +
                "------------------------------------------------------------\n";
    }

    ArrayList<String> historicoDeOperacoes = new ArrayList<String>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= valor;
        historicoDeOperacoes.add("Saque de R$ " + valor + " realizado em " + java.time.LocalDateTime.now().format(formatter));
    }

    public void depositar(double valor) {
        this.saldo += valor;
        historicoDeOperacoes.add("Depósito de R$ " + valor + " realizado em " + java.time.LocalDateTime.now().format(formatter));
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= valor;
        contaDestino.depositar(valor);
        historicoDeOperacoes.add("\n"
        + "Transferência de R$ " + valor +"\n"
        + "\t" + " Para: "+ contaDestino.getNomeCliente() +"\n"
        + "\t" + " Agencia: "+ contaDestino.getAgencia() +"\n"
        + "\t" + " Conta: "+ contaDestino.getNumero() +"\n"
        + "\t" + " Realizada em: " + java.time.LocalDateTime.now().format(formatter) +"\n");
    } 

    public void extrato() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Extrato das Operações:                                     |");
        System.out.println("------------------------------------------------------------");
        for (String operacao : historicoDeOperacoes) {
            System.out.println(operacao);
        }
        System.out.println("Saldo atual: " + String.format("%.2f", saldo));
    }
}
