public class Mesa {

    private String data;
    private int numeroMesa;
    private boolean reserva;

    public String getData()                     { return this.data; }
    public int getNumeroMesa()                  { return this.numeroMesa; }
    public boolean getReserva()                 { return this.reserva; }

    public Mesa (String data_p,int num_p) {

        this.numeroMesa = num_p;
        this.data = data_p;
        this.reserva = false;
    }

    // public boolean reservar () {}

    // Setters
    /*
    public void setData(String data_p)          {this.data = data_p; }
    public void setReserva(boolean bool_p)      { this.reserva = bool_p; }
    public void setNumeroMesa(int num_p)        { this.numeroMesa = num_p; } 
    */
}
