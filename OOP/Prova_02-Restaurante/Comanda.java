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

    public void listar_Consumo() { 

        System.out.print("________________________________________");
        System.out.print("\n" + this.consumo);
        System.out.println("________________________________________");
        System.out.println("Total: " + this.valor + " reais");
        System.out.println("\nAgradecemos a preferência e volte sempre!");
    }
}