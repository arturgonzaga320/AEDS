// Trabalho Final de AEDS: Restaurante Buchinho Cheio
// Artur Gonzaga da Silva Gomes - 203A

public class Produto {
    
    private String nome;
    private double valor;

    // Getters
    public String getNome()     { return this.nome;}
    public double getValor()    { return this.valor;}

    // Setters
    public void setNome(String nome_p)          { this.nome = nome_p; }
    public void setValor(double valor_p)        { this.valor = valor_p;}

    public Produto (String nome_p,double valor_p) {
        this.nome = nome_p;
        this.valor = valor_p;
    }
}
