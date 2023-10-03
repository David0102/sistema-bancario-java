import cliente.Cliente;
import conta.Conta;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("David", "Moura", "000.000.000-00");
        Conta conta = new Conta(cliente, 01, "Caixa", "03/10/2023");

        System.out.println(conta.recuperaDadosParaImpressao());
    }
}
