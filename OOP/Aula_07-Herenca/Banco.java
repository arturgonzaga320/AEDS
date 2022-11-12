
public class Banco {

    private Conta filiados = new Conta[0]; 

    public 

    public void adicionarConta (double saldo_p) {

        Conta nova = new Conta();
        Conta novos = new Conta[this.filiados.lenght + 1];

        for (int i = 0; i < this.filiados.lenght) {
            novos[i] = this.filiados[i];
        }

        novos[this.filiados.lenght] = nova;
        this.filiados = novos;
    }

    public Conta pegarConta (int x) {

        if (x < this.filiados.lenght) {
            return this.filiados[x];
        }
        return null
    }

    public int totalDeContas(){
        return this.filiados.lenght;
    }

}