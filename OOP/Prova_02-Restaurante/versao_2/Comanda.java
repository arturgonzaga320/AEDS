import java.util.Scanner;

public class Comanda {

    protected double valor = 0.00;
    protected String consumo = "\n";
    private Comanda_var[] tipos = new Comanda_var[0];
    
    // Getters
    public double getValor()                        { return this.valor; }
    public String getConsumo()                      { return this.consumo; }

    // Setters
    public void setValor (double valor_p)           { this.valor = valor_p;}
    public void setConsumo (String consumo_p)       { this.consumo = consumo_p; }

    public void setComandas_categs (String[] categs) {

        Comanda_var[] aux_g = new Comanda_var[categs.length];

        for (int i = 0; i < categs.length; i++) {

            aux_g[i] = new Comanda_var();
            aux_g[i].setCategoria(categs[i]);
        }

        this.tipos = aux_g;
    }
	
    private int buscar_Categoria (Produto pedido) {
	
        for (int i = 0; i < this.tipos.length; i++) {

            // Caso categoria seja encontrada
            if (this.tipos[i].getCategoria().equals(pedido.getCategoria()))	return i;
        }

        return this.tipos.length - 1;
    }

    public void incrementar (Produto nv_pedido) {

        String aux = nv_pedido.getValor() + "\t" + nv_pedido.getNome() + "\n";

        // Incrementa consumos
        int n = buscar_Categoria(nv_pedido);
        this.tipos[n].setConsumo(this.tipos[n].getConsumo().concat(aux));

        // Incrementa preços
        this.valor += nv_pedido.getValor();
        this.tipos[n].setValor(this.tipos[n].getValor() + nv_pedido.getValor());
    }

    public void listar_Consumo(int n_pessoas,Scanner scan) { 

        for (int i = 0; i < tipos.length; i++) {

            this.tipos[i].listar_Consumo(n_pessoas,scan);
        }

        System.out.println("_______________________________________________________");

        if (this.valor > 50.0) {

            this.valor -= this.calcular_10porcento();
            System.out.println("Valor total acima de 50 reais, \u001B[32m10% de desconto!\u001B[37m");
        }

        System.out.print("\u001B[33m");
        System.out.printf ("Total: %.2f", this.valor);
        System.out.println(" reais\u001B[37m");

        if (n_pessoas > 1){

            System.out.print("\nDividir conta entre as pessoas da mesa(s/n): ");
            char opcao = scan.next().charAt(0);

            if (opcao == 's'){

                System.out.print("\u001B[33m");
                System.out.printf ("R$ %.2f por pessoa\u001B[37m\n", this.dividir_Conta(n_pessoas));
            }
        }

        System.out.println("\nAgradecemos pela preferência e volte sempre!");
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
