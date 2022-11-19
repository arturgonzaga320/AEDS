import java.util.Scanner;

public class Mesa {

    private Data data;
    private int numeroMesa;
    private boolean reserva;
    private Cliente[] clientes;
    private Comanda conta;

    // Getters
    public int getNumeroMesa()                  { return this.numeroMesa; }
    public boolean getReserva()                 { return this.reserva; }
    public Cliente[] getClientes()              { return this.clientes; }
    public Comanda getComanda()                 { return this.conta; }

    // Setters
    public void setComanda(Comanda nova)        { this.conta = nova; }
    public void setNumeroMesa(int num_p)        { this.numeroMesa = num_p; } 
    public void setReserva(boolean bool_p)      { this.reserva = bool_p; }
    public void setClientes(Cliente[] novos_p)  { this.clientes = novos_p;}

    public void setData( int dia, int mes, int ano){

        /* 
        Scanner scanner = new Scanner (System.in);

        System.out.print("\n\tMes: ");
        int mes = scanner.nextInt();

        System.out.print("\tDia: ");
        int dia = scanner.nextInt();

        //System.out.print("\n\tAno: ");
        int ano = 2022; //int ano = scanner.nextInt();
        System.out.println();

        scanner.close();
        */
        this.data.setData(dia, mes, ano);
    }

    public Mesa (String data_p,int num_p) {

        this.numeroMesa = num_p;
        this.reserva = false;
        Comanda n_conta = new Comanda();
        this.conta = n_conta;
    }

    public Cliente adicionarCliente() {

        Scanner scanner = new Scanner (System.in);

        System.out.print("\tNome: ");
        String n_p = scanner.next();

        System.out.print("\n\tE_mail: ");
        String e_p = scanner.next();

        System.out.println();
        Cliente novo = new Cliente(n_p, e_p);

        scanner.close();
        return novo;
    }

    public boolean reservar(int qnt_pessoas,Data horario) {

        // Caso a mesa ja esteja reservada
        if (this.reserva == true) return false;

        Cliente[] novos = new Cliente[qnt_pessoas];
        for (int i = 0; i < qnt_pessoas; i++){
            
            novos[i] = this.adicionarCliente();
        }

        this.setClientes(novos);
        // this.setData();

        this.reserva = true;
        return true;
    }
}
