public class Funcionario {
    
    String nome;            // Nome
    String rg;              // Registo Geral
    Data entrada = new Data();    // Credenciado desde
    int num_setor;          // Local onde trabalha
    double salario;         // Salario em reais

    public void show(){

        System.out.println(this.nome);
        System.out.println(this.rg);
        System.out.println(this.entrada.dia+ "/" + this.entrada.mes + "/" + this.entrada.ano );
        System.out.println(this.num_setor);
        System.out.println(this.salario);
    }
}