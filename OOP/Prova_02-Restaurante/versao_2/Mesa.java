import java.util.Scanner;

public class Mesa {

    private int num_mesa;
    // private int num_categoria;
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
    public void reservar(int qnt_pessoas,Data nova_data,String[] categs, Scanner scan) {

        System.out.print("\u001B[34m");
        System.out.println("\n>> Agendamento da reserva: CLIENTES <<\u001B[37m");

        Cliente[] novos = new Cliente[qnt_pessoas];

        for (int i = 0; i < qnt_pessoas; i++) {

            System.out.println ("\u001B[33m");
            System.out.println ("Cliente " + (i + 1)+ "\u001B[37m");
            novos[i] = nova_data.adicionar_Cliente(scan);
        }

        Data[] up_dates = new Data[this.checks.length + 1];

        // Transcreve informações para o novo vetor
        for (int i = 0; i < this.checks.length; i++) up_dates[i] = this.checks[i];

        nova_data.setPessoas(novos);
        nova_data.preparar_Comanda(categs);
        up_dates[this.checks.length] = nova_data;

        this.checks = up_dates;
        this.reserva = true;
    }

    public Mesa buscar_Reserva(Data data_ref) {

        if (!this.reserva) return null;

        for (int i = 0; i < this.checks.length; i++) {

            // Caso reserva seja encontrada
            if (this.checks[i].comparar_Data(data_ref)) return this;
        }
        return null;
    }

    public void liberar_Reserva(Data data_ref,Scanner scan) {

        if (!this.reserva) return;

        Data[] aux = new Data [this.checks.length - 1];

        for (int i = 0, j = 0; i < this.checks.length; i++) {

            if (this.checks[i].comparar_Data(data_ref)) {

                // Imprime comanda
                this.checks[i].getConta().listar_Consumo(this.checks[i].getPessoas().length,scan);
            }
            else {

                aux[j] = this.checks[i];
                j++;
            }
        }

        if (aux.length == 0) this.reserva = false;
        this.checks = aux;
    }
}
