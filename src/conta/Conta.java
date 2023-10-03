package conta;

import cliente.Cliente;

public class Conta {
    private int id;
    private Cliente titular;
    private int numero;
    private String agencia;
    private String dataAbertura;
    private double saldo;
    private static int proximoId = 1;
    private static int totalDeContas = 0;

    public Conta(Cliente cliente, int numero, String agencia, String dataAbertura) {
        this.id = proximoId;
        this.titular = cliente;
        this.numero = numero;
        this.agencia = agencia;
        this.dataAbertura = dataAbertura;
        this.saldo = 0;
        Conta.totalDeContas = totalDeContas + 1;
        proximoId++;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public String getDataAbertura() {
        return this.dataAbertura;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public static int getTotalDeContas() {
        return Conta.totalDeContas;
    }

    public int getId() {
        return this.id;
    }

    public double getRedimento() {
        return this.saldo * 0.1;
    }

    public boolean saca(double valor) {
        if (this.saldo < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public String recuperaDadosParaImpressao() {
        return String.format(
                "Id: %d\nTilular: %s\nNumero: %d\nAgencia: %s\nData de abertura: %s\nSaldo: %.2f\nRendimento: %.2f",
                this.id, this.titular.getNome(), this.numero, this.agencia, this.dataAbertura, this.saldo,
                this.getRedimento());
    }

    public boolean transfere(Conta destino, double valor) {
        if (this.saca(valor)) {
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }
}