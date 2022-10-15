public class Empresa {
    
    private String nome = "NULL";
    private String dono = "NULL";
    private String cnpj = "NULL";

    private Funcionario[] empregados = new Funcionario[0];

    public void definir_dadosBasicos (String nome_p,String dono_p,String cnpj_p){

        this.nome = nome_p;
        this.dono = dono_p;
        this.cnpj = cnpj_p;
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

            System.out.println ("> Empregada(o) da posicao: " + i);
            this.empregados[i].show();
            System.out.println ();
        }
    }

    public void mostra_empresa (){

        System.out.println (this.nome);
        System.out.println ("Dono: " + this.dono);
        System.out.println ("CNPJ: " + this.cnpj + "\n");
        this.mostra_empregados();
    }
}
