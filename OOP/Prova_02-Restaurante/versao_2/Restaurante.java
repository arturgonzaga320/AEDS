public class Restaurante {
    
    private String nome;
    private String endereco;
    private Mesa[] mesas = new Mesa[0];
    private Produto[] cardapio = new Produto[0];
    private String[] categorias = new String[0];

    // Getters
    public String getNome()             { return this.nome;}
    public Mesa[] getMesas()            { return this.mesas;}
    public String getEndereco()         { return this.endereco;}
    public Produto[] getCardapio()      { return this.cardapio;}
    public String[] getCategorias()     { return this.categorias;}

    // Setters
    public void setNome (String nome_p)             { this.nome = nome_p;}
    public void setMesas (Mesa[] mesas_p)           { this.mesas = mesas_p;}
    public void setEndereco (String end_p)          { this.endereco = end_p;}
    public void setCardapio (Produto[] card_p)      { this.cardapio = card_p;}
    public void setCategorias (String[] cat_p)      { this.categorias = cat_p;}

    // Constructors
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
    
    public Mesa[] listar_Agendamentos (Data data_p) {

        int k = 0;
        for (int i = 0; i < this.mesas.length; i++) {

            // Define tamanho de vetor de mesas com reservas
            if (this.mesas[i].buscar_Reserva(data_p) != null) k++;
        }

        Mesa[] aux = new Mesa [k];
        for (int i = 0, j = 0; i < this.mesas.length; i++) {
            
            if (this.mesas[i].buscar_Reserva(data_p) == this.mesas[i]) {
                aux[j] = this.mesas[i];
                j++;
            } 
        }
        return aux;
    }
}
