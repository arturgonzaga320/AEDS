public class Comanda {

    private double valor = 0.00;
    private String consumo;
    
    // Getters
    public double getValor()                        { return this.valor; }
    public String getConsumo()                      { return this.consumo; }

    // Setters
    public void setValor (double valor_p)           { this.valor = valor_p;}
    public void setConsumo (String consumo_p)       { this.consumo = consumo_p; }

    public void incrementar (Produto nv_pedido) {

        String aux = nv_pedido.getValor() + "\t" + nv_pedido.getNome() + "\n";
        
        this.consumo.concat(aux);
        this.valor += nv_pedido.getValor();
    }

    public void listarConsumo() { 

        System.out.println(this.consumo);
    }
}