import java.util.Scanner;

public class Comanda {

    private double valor = 0.00;
    private String consumo = "\n";
    
    // Getters
    public double getValor()                        { return this.valor; }
    public String getConsumo()                      { return this.consumo; }

    // Setters
    public void setValor (double valor_p)           { this.valor = valor_p;}
    public void setConsumo (String consumo_p)       { this.consumo = consumo_p; }

    public void incrementar (Produto nv_pedido) {

        String aux = nv_pedido.getValor() + "\t" + nv_pedido.getNome() + "\n";
        
        this.consumo = this.consumo.concat(aux);
        this.valor += nv_pedido.getValor();
    }

    public void listar_Consumo(Scanner scan, int n_pessoas) { 

        System.out.print("________________________________________");
        System.out.print("\n" + this.consumo);
        System.out.println("________________________________________");

        if (this.valor > 50.0) {

            this.valor -= this.calcular_10porcento();
            System.out.println("Valor total acima de R$ 50.00, 10% de desconto!");
        }

        System.out.println("Total: " + this.valor + " reais");

        if (n_pessoas > 1){

            System.out.println("\nDeseja dividir a conta entre as pessoas da mesa( 0 para NÃO - 1 para SIM): ");
            System.out.print("> ");
            int opcao = scan.nextInt();

            if (opcao == 1)
                System.out.println("Cada pessoa paga R$" + this.dividir_Conta(n_pessoas)) ;
        }

        System.out.println("\nAgradecemos a preferência e volte sempre!");
    }

    public double calcular_10porcento(){

        double desconto = this.valor/10;
        return desconto;
    }

    public double dividir_Conta(int n_pessoas) {

        double valor_meiado = this.valor / n_pessoas;
        return valor_meiado;
    }
}