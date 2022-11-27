public class Produto {
    
    private String nome;
    private double valor;
    private String categoria;

    // Getters
    public String getNome()		{ return this.nome;}
    public double getValor()		{ return this.valor;}
    public String getCategoria()	{ return this.categoria;}

    // Setters
    public void setNome(String nome_p)			{ this.nome = nome_p;}
    public void setValor(double valor_p)		{ this.valor = valor_p;}
    public void setCategoria(String categ_p)    { this.categoria = categ_p;}

    public Produto (String nome_p,double valor_p, String categ_p) {
        this.nome = nome_p;
        this.valor = valor_p;
	this.categoria = categ_p;
    }
}
