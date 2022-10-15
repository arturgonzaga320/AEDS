public class Main {

    public static void main(String args[]){

        System.out.println();

        Funcionario Artur = new Funcionario();
        Funcionario Anakin = new Funcionario();

        // Preeche Artur
        Artur.nome = "Artur Gonzaga";
        Artur.salario = 4500;
        Artur.rg = "132.435.233-MG";
        Artur.entrada.dia = 10;
        Artur.entrada.mes = 04;
        Artur.entrada.ano = 2018;
        Artur.num_setor = 14;
            
        // Preeche Anakin
        Anakin.nome = "Anakin Rhami";
        Anakin.salario = 1500;
        Anakin.rg = "145.242.190-MG";
        Anakin.entrada.dia = 14;
        Anakin.entrada.mes = 06;
        Anakin.entrada.ano = 2021;
        Anakin.num_setor = 14;

        Empresa cia = new Empresa();

        String nome_empresa = "Logic company";
        String dono_empresa = "Zeh das couves";
        String cnpj = "645.123.1.788";
        cia.definir_dadosBasicos(nome_empresa,dono_empresa,cnpj);

        cia.contratar_funcionario(Artur);
        cia.contratar_funcionario(Anakin);

        cia.mostra_empresa();
    }

}