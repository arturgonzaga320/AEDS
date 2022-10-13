public class Porta {

    // porta inicia fechada
    private boolean estado = false;

    public void abrir() {
        this.estado = true;
    }

    public void fechar() {

        this.estado = false;
    } 
    public boolean mostrar_estado() {

        return this.estado;
    }

}
