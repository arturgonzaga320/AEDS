public class Empresa {
    
    private Funcionario[] empregados;
    private String cnpj = "NULL";

    public void definir_cnpj (String novo_cnpj){

        this.cnpj = novo_cnpj;
    }

    public void contratar_funcionario (Funcionario novo_empregado) {

        Funcionario nova_equipe [] = new Funcionario [this.empregados.length + 1];

        for (int i = 0; i < this.empregados.length; i++){

            nova_equipe[i] = this.empregados[i];
        }

        nova_equipe[this.empregados.length] = novo_empregado;
        this.empregados = nova_equipe;
    }

    public void mostra_empregados () {

        for (int i = 0; i < this.empregados.length; i++) {

            System.out.println ("Empregada(o) da posicao: " + i);
            this.empregados[i].show();
        }
    }

    public void mostra_empresa (){

        System.out.println ("CNPJ: " + this.cnpj);
        this.mostra_empregados();
    }
}
