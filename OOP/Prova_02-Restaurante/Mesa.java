import java.util.Scanner;

public class Mesa {

    private Data data = new Data(30,2,2020);
    private int numeroMesa;
    private boolean reserva;
    private Cliente[] clientes = new Cliente [8];
    private Comanda conta = new Comanda();

    // Getters
    public int getNumeroMesa()                  { return this.numeroMesa; }
    public boolean getReserva()                 { return this.reserva; }
    public Cliente[] getClientes()              { return this.clientes; }
    public Comanda getComanda()                 { return this.conta; }
    public Data getData()                       { return this.data; }

    // Setters
    public void setData(Data data_p)            { this.data = data_p; }
    public void setComanda(Comanda nova)        { this.conta = nova; }
    public void setNumeroMesa(int num_p)        { this.numeroMesa = num_p; } 
    public void setReserva(boolean bool_p)      { this.reserva = bool_p; }
    public void setClientes(Cliente[] novos_p)  { this.clientes = novos_p;}

    public Mesa (String data_p,int num_p) {

        this.numeroMesa = num_p;
        this.reserva = false;
        Comanda n_conta = new Comanda();
        this.conta = n_conta;
    }

    public Mesa() { }
    public Cliente adicionarCliente( Scanner scanner) {

        System.out.print("\tNome: ");
        String n_p = scanner.next();

        System.out.print("\tE_mail: ");
        String e_p = scanner.next();

        System.out.println();
        Cliente novo = new Cliente(n_p, e_p);

        return novo;
    }

    public boolean reservar(int qnt_pessoas,Data horario, Scanner scan) {

        // Caso a mesa ja esteja reservada
        if (this.reserva == true) return false;

        Cliente[] novos = new Cliente[qnt_pessoas];
        System.out.println(">> Agendamento da reserva: CLIENTES <<");
        for (int i = 0; i < qnt_pessoas; i++){
            
            novos[i] = this.adicionarCliente(scan);
        }

        this.setClientes(novos);
        this.setData(horario);

        this.reserva = true;
        return true;
    }
}