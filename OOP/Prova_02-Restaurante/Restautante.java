public class Restautante {
    
    private String nome;
    private String endereco;

    // Getters
    public String getNome()     { return this.nome; }
    public String getEndereco() { return this.endereco; }

    public Restautante (String nome_p,String end_p) {

        this.nome = nome_p;
        this.endereco = end_p;
    }
}
