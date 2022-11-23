public class Restaurante {
    
    private String nome;
    private String endereco;
    private Mesa[] mesas = new Mesa[0];
    private Produto[] cardapio = new Produto[0];

    // Getters
    public String getNome()             { return this.nome;}
    public Mesa[] getMesas()            { return this.mesas;}
    public String getEndereco()         { return this.endereco;}
    public Produto[] getCardapio()      { return this.cardapio;}

    // Setters
    public void setNome (String nome_p)             {this.nome = nome_p;}
    public void setMesas (Mesa[] mesas_p)           {this.mesas = mesas_p;}
    public void setEndereco (String end_p)          {this.endereco = end_p;}
    public void setCardapio (Produto[] card_p)      {this.cardapio = card_p;}

    public Restaurante (String nome_p,String end_p,int qnt_mesas) {

        this.nome = nome_p;
        this.endereco = end_p;

        Mesa[] novas = new Mesa[qnt_mesas];
        for (int i = 0; i < qnt_mesas; i++) { 

            novas[i] = new Mesa();
            novas[i].setNumeroMesa(i); 
        }
        this.setMesas(novas);
    }
}
