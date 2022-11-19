public class Restaurante {
    
    private String nome;
    private Mesa[] mesas;
    private String endereco;
    private Produto[] cardapio;

    // Getters
    public String getNome()             {return this.nome;}
    public Mesa[] getMesas()            {return this.mesas;}
    public String getEndereco()         {return this.endereco;}
    public Produto[] getCardapio()     {return this.cardapio;}

    // Setters
    public void setNome (String nome_p)             {this.nome = nome_p;}
    public void setMesas (Mesa[] mesas_p)           {this.mesas = mesas_p;}
    public void setEndereco (String end_p)          {this.endereco = end_p;}
    public void setCardapio (Produto[] card_p)      {this.cardapio = card_p;}

    public Restaurante (String nome_p,String end_p,int qnt_mesas) {

        this.nome = nome_p;
        this.endereco = end_p;

        Mesa novas[] = new Mesa[qnt_mesas];
        for (int i = 0; i < qnt_mesas; i++) { novas[i].setNumeroMesa(i); }
        this.setMesas(novas);
    }
}
