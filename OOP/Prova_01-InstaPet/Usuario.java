public class Usuario {
    
    private String nome;
    private String e_mail;
    
    private Foto galeria [] = new Foto[0];
    private int total_fotos = 0;

    // Getters
    public String getNome ()                            { return this.nome; }
    public String getE_mail ()                          { return this.e_mail; }
    public Foto getGaleria (int i)                      { return this.galeria[i]; }
    public int getTotal_fotos()                         { return this.total_fotos; }

    // Setters
    public void setNome (String nome_p)                 { this.nome = nome_p; }
    public void setE_mail (String e_mail_p)             { this.e_mail = e_mail_p; }
    public void setTotal_fotos (int total_p)            { this.total_fotos = total_p; }
    public void setGaleria (Foto[] galeria_p)           { this.galeria = galeria_p; }


    
    public void cadastrar_foto (String novo_url, String nova_descricao) {

        Foto nova_foto = new Foto();

        nova_foto.setUrl(novo_url);
        nova_foto.setDescricao(nova_descricao);

        Foto nova_galeria [] = new Foto[this.getTotal_fotos() + 1];

        if (this.getTotal_fotos() > 0) {

            for (int i = 0; i < this.getTotal_fotos(); i++) {

                nova_galeria [i] = this.getGaleria(i);
            }
        }

        nova_galeria [this.getTotal_fotos()] = nova_foto;

        this.setTotal_fotos( this.getTotal_fotos() + 1 );
        this.setGaleria(nova_galeria);

    }

    public void alterar_descricao (String url_alvo, String nova_descricao) {

        int i;
        for (i = 0; ( i < this.total_fotos ) &&  ( this.galeria[i].getUrl() != url_alvo ); i++);
        
        if ( i < this.total_fotos ) {

            this.galeria[i].setDescricao(nova_descricao);
        }

    }

}
