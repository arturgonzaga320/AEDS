public class Comanda {

    private double valor = 0.00;
    private String consumo;
    
    // Getters
    public double getValor()                        { return this.valor; }
    public String getConsumo()                      { return this.consumo; }

    public void incrementar (String produto,double valor) {

        String aux = "\n";
        aux.concat(produto);
        
        this.consumo.concat(aux);
        this.consumo += valor;
    }

    // public void listarConsumo() { }

        
    // Setters
    /* 
    public void setValor (double valor_p)           { this.valor = valor_p;}
    public void setConsumo (String consumo_p)       { this.consumo = consumo_p; }
    */
}