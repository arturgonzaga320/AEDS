import java.util.Scanner;

public class Mesa {

    private int num_mesa;
    private Data[] checks = new Data[0];
    private boolean reserva = false;

    // Getters
    public int getNumeroMesa()                  { return this.num_mesa; }
    public boolean getReserva()                 { return this.reserva; }
    public Data[] getData()                     { return this.checks; }

    // Setters
    public void setData(Data[] data_p)          { this.checks = data_p; }
    public void setNumeroMesa(int num_p)        { this.num_mesa = num_p; } 
    public void setReserva(boolean bool_p)      { this.reserva = bool_p; }

    // Constructors
    public Mesa(/* Sem parametros */)   { /* Sem modificações; */ }
    public Mesa(int num_p)              { this.num_mesa = num_p;}

    // Methods
    public void reservar(int qnt_pessoas,Data nova_data, Scanner scan) {

        System.out.println("\n>> Agendamento da reserva: CLIENTES <<");

        Cliente[] novos = new Cliente[qnt_pessoas];
        for (int i = 0; i < qnt_pessoas; i++) {
            System.out.println("Cliente " + (i + 1));
            novos[i] = nova_data.adicionarCliente(scan);
        }

        Data[] up_dates = new Data[this.checks.length + 1];
        for (int i = 0; i < this.checks.length; i++)
           up_dates[i] = this.checks[i];

        nova_data.setPessoas(novos);
        up_dates[this.checks.length] = nova_data;

        this.checks = up_dates;
        this.reserva = true;
    }

    public Mesa buscar_Reserva(Data data_ref) {

        Mesa aux = new Mesa();
        for (int i = 0; i < this.checks.length; i++) {

            if (this.checks[i].compararData(data_ref)) 
                aux = this;                 // Caso seja true  
        }
        return aux;
    }
}