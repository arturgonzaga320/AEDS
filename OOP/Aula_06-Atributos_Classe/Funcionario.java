public class Funcionario {
    
    // Atributos 
    private String nome;                    // Nome
    private String rg;                      // Registo Geral
    private Data entrada = new Data();      // Credenciado desde
    private int num_setor;                  // Local onde trabalha
    private double salario;                 // Salario em reais
    private int identificador;              // Ordem de criacao
    private static int total_Funcionarios;

    // Constructors
    Funcionario() {
        
        Funcionario.total_Funcionarios++;
        this.setIdentificador (Funcionario.total_Funcionarios);
    
    }
    Funcionario(String nome) { 
        
        this.setNome (nome);
        Funcionario.total_Funcionarios++;
        this.setIdentificador (Funcionario.total_Funcionarios);
    }

    // Setters
    public void setNome (String nome_p)         { this.nome = nome_p; }
    public void setRG (String RG_p)             { this.rg = RG_p; }
    public void setSetor(int setor_p)           { this.num_setor = setor_p; }
    public void setSalario(double salario_p)    { this.salario = salario_p; }
    public void setIdentificador (int id_p)     { this.identificador = id_p; }

    public void setEntrada (int dia, int mes, int ano){ 

        Data data_p = new Data();
        data_p.setData(dia,mes,ano);

       this.entrada = data_p; 
    }

    // Getters
    public String getNome()                 { return this.nome; }
    public String getRG()                   { return this.rg; }
    public Data getData()                   { return this.entrada; }
    public int getSetor()                   { return this.num_setor; }
    public double getSalario()              { return this.salario; }
    public int getIndetificador()           { return this.identificador; }
    public int getTotalFuncionarios()       {return Funcionario.total_Funcionarios; }

    public void showFuncionario(){

        System.out.println(" " + "\u001B[32m" + this.getNome().toUpperCase()+ "\u001B[0m" );
        System.out.println("  RG: " + "\u001B[32m" + this.getRG() + "\u001B[0m" );
        System.out.println("  Ingressado em: " + "\u001B[32m" + this.entrada.dia+ "/" + this.entrada.mes + "/" + this.entrada.ano + "\u001B[0m" );
        System.out.println("  Setor: " + "\u001B[32m" + this.getSetor() + "\u001B[0m");
        System.out.println("  Salario: " + "\u001B[32m" + this.getSalario()+ "\u001B[0m" );
    }
}