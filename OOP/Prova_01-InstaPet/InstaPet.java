public class InstaPet {
    
    private int total_usuarios = 0;
    private Usuario comunidade [] = new Usuario[0];

    // Getters
    public int getTotalUsuarios ()                                      { return this.total_usuarios; }
    public Usuario[] getComunidade ()                                   { return this.comunidade; }
    public Usuario getMembro(int i)                                     { return this.comunidade[i]; }

    // Setters
    public void setTotalUsuarios (int total_p)                          { this.total_usuarios = total_p; }
    public void setComunidade (Usuario[] comunidade_p)                  { this.comunidade = comunidade_p; }


    // Metodos internos
    private Usuario buscarUsuario (String email_alvo) {

        int i = 0;
        while (i < this.getTotalUsuarios()) {

            if ( email_alvo.equals ( this.getMembro(i).getE_mail() ) ) {

                return this.getMembro(i);
            }
            
            else i++;
        }

        return null;
    }
    
    private Foto buscarFoto (Usuario dono, String url_alvo) {

        int i = 0;
        while ( i < dono.getTotal_fotos()) {

            if ( url_alvo.equals ( dono.getGaleria(i).getUrl() ) ) {

                return dono.getGaleria(i); 
            }

            else i++;
        }

        return null;
    }

    // Metodos publicos
    public void cadastrar_usuario (String novo_nome, String novo_e_mail){

        Usuario novo_usuario = new Usuario();

        novo_usuario.setNome(novo_nome);
        novo_usuario.setE_mail(novo_e_mail);

        Usuario nova_comunidade [] = new Usuario[this.total_usuarios + 1];

        if (this.total_usuarios > 0) {

            for (int i = 0; i < this.total_usuarios; i++) {

                nova_comunidade [i] = this.comunidade[i];
            }
        }

        nova_comunidade [this.total_usuarios] = novo_usuario;
        this.total_usuarios ++;

        this.comunidade = nova_comunidade;
        
    }

    public void cadastrar_foto (String user_email, String novo_url, String nova_descricao) {

        Usuario aux = this.buscarUsuario(user_email);
        
        aux.cadastrar_foto(novo_url, nova_descricao);
    }
    
    public int qnt_usuarios () { 
        
        return this.total_usuarios; 
    }
    
    public int qnt_pets (String email_alvo) {

        Usuario aux = buscarUsuario(email_alvo);

        return aux.getTotal_fotos();
    }

    public void alterar_descricao (String email_alvo, String url_alvo, String nova_descricao) {

        Usuario aux = buscarUsuario(email_alvo);
        Foto aux_b = buscarFoto(aux, url_alvo);

        aux.alterar_descricao(aux_b.getUrl(), nova_descricao);
    }


    public Foto [] listar_pets (String email_alvo) {

        Usuario aux = this.buscarUsuario(email_alvo);
        if ( aux == null) return null;

        Foto galeria_s [] = new Foto [aux.getTotal_fotos()];
        
        if (aux.getTotal_fotos() > 0) {

            for (int i = 0; i < aux.getTotal_fotos(); i++) {

                galeria_s[i] = aux.getGaleria(i);
            }

        } else galeria_s = null;

        return galeria_s; 
    }

    public Usuario [] listar_Usuarios () {

        return this.comunidade;
    }

}
