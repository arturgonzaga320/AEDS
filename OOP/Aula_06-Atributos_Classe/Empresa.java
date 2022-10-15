public class Empresa {
    
    private String nome = "NULL";
    private String dono = "NULL";
    private String cnpj = "NULL";

    private Funcionario[] empregados = new Funcionario[0];

    // Setters
    public void setNome (String nome_p) { this.nome = nome_p;}
    public void setDono (String dono_p) { this.dono = dono_p;}
    public void setCNPJ (String cnpj_p) { this.cnpj = cnpj_p;}

    // getters
    public String getNome () { return this.nome; }
    public String getDono () { return this.dono; }
    public String getCNPJ () { return this.cnpj; }

    public void contratar_funcionario (Funcionario novo_empregado) {

        Funcionario nova_equipe [] = new Funcionario [this.empregados.length + 1];

        for (int i = 0; i < this.empregados.length; i++){

            nova_equipe[i] = this.empregados[i];
        }

        nova_equipe[this.empregados.length] = novo_empregado;
        this.empregados = nova_equipe;
    }

    public void showEmpregados () {

        for (int i = 0; i < this.empregados.length; i++) {

            System.out.print ("> Empregada(o) " + this.empregados[i].getIndetificador() + ":");
            this.empregados[i].showFuncionario();
            System.out.println ();
        }
    }

    public void showEmpresa (){

        System.out.println ("\u001B[45m" + "\033[1m" + " " + this.getNome().toUpperCase() + " " + "\u001B[0m" );
        System.out.println ("Dono: " + "\u001B[32m" + this.getDono().toUpperCase() + "\u001B[0m" );
        System.out.println ("CNPJ: " + "\u001B[32m" + this.getCNPJ() + "\u001B[0m" + "\n");
        this.showEmpregados();
    }
}
