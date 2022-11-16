public class Cliente {

    private String nome;
    private String email;

    // Getters
    public String getNome ()                        { return this.nome; }
    public String getEmail()                        { return this.email; }

    public Cliente (String nv_nome,String nv_email) {
        
        this.nome = nv_nome;
        this.email = nv_email;
    }


    // Setters
    /*
    public void setNome (String nome_p)             {this.nome = nome_p;}
    public void setEmail (String email_p)           {this.email = email_p;}
    */
}