
public class Banco {

    private Conta filiados[] = new Conta[0]; 

    public void adicionarConta (Conta nova) {

        Conta novos[] = new Conta[this.totalDeContas() + 1];

        for (int i = 0; i < this.totalDeContas(); i++) {
            novos[i] = this.filiados[i];
        }

        novos[this.totalDeContas()] = nova;
        this.filiados = novos;
    }

    public Conta pegarConta (int x) {

        if (x < this.totalDeContas()) {
            return this.filiados[x];
        }
        return null;
    }

    public int totalDeContas(){
        return this.filiados.length;
    }

}