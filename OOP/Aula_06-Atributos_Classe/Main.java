public class Main {

    public static void main(String args[]){

        System.out.println();

        Funcionario Artur = new Funcionario("Artur Gonzaga");
        Funcionario Anakin = new Funcionario();

        // Preeche Artur
        Artur.setSalario            (4500);
        Artur.setRG                 ("132.435.233-MG");
        Artur.setEntrada            (10, 14,2018);
        Artur.setSetor              (14);
            
        // Preeche Anakin
        Anakin.setNome              ("Anakin Rhami");
        Anakin.setSalario           (1500);
        Anakin.setRG                ("145.242.190-MG");
        Anakin.setEntrada           (30, 02,2021); 
        Anakin.setSetor             (14);

        Empresa cia = new Empresa();

        cia.setNome                 ("Logic company");
        cia.setDono                 ("Zeh das couves");
        cia.setCNPJ                 ("645.123.1.788");

        cia.contratar_funcionario(Artur);
        cia.contratar_funcionario(Anakin);

        cia.showEmpresa();
    }

}