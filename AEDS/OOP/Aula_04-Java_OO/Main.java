public class Main {

    public static void main(String args[]){

        System.out.println();

        Funcionario Artur = new Funcionario();
        Funcionario Anakin = new Funcionario();

        Artur.nome = "Artur Gonzaga";
        Artur.salario = 4500;
        Artur.rg = "132.435.233-MG";

        // Antes de Data ser classe, era assim:
        // Artur.entrada = "10/04/2018";

        Artur.entrada.dia = 10;
        Artur.entrada.mes = 04;
        Artur.entrada.ano = 2018;
        Artur.num_setor = 14;
            
        Anakin.nome = "Anakin Rhami";
        Anakin.salario = 1500;
        Anakin.rg = "145.242.190-MG";

        // Antes de Data ser classe, era assim:
        // Anakin.entrada = "14/06/2021";

        Anakin.entrada.dia = 14;
        Anakin.entrada.mes = 06;
        Anakin.entrada.ano = 2021;
        Anakin.num_setor = 14;


        // Anakin = Artur;
        Artur.show(); 
        Anakin.show();
        
        if (Artur == Anakin) {
            
            // Quer dizer que Artur e Anakin sao
            // referencias para um mesmo Funcionario
            System.out.println("\n>> Iguais <<");

        }
        else{
             
            // Quer dizer que Artur e Anakin sao
            // referencias para diferentes Funcionario(s)
            System.out.println("\n>> Diferentes <<");
        }
    }

}