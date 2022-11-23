public class Data {
    
    private int dia;
    private int mes;
    private int ano;

    public String getData (){

        String data_p = this.dia + "/" + this.mes + "/" + this.ano;
        return data_p;
    }
    // Contructor = Set sem validacao de Data
    public Data (int dia_p, int mes_p, int ano_p){

        this.dia = dia_p;
        this.mes = mes_p;
        this.ano = ano_p;
    }

    public void validar_Data() {

        if (this.dia > 28 && this.mes == 2) {

            this.mes +=this.dia / 30;

            this.dia = this.dia - 28;

            this.validar_Data ();
        }
        
        if (this.dia > 30) {

            this.mes +=this.dia / 30;

            if (this.mes == 2) { this.dia = this.dia % 28; }
            else this.dia = this.dia % 30;

            this.validar_Data ();
        }

        if (this.mes > 12) {

            this.ano +=   this.mes / 12;
            this.mes =    this.mes % 12;

            this.validar_Data ();
        }

    }
    public void setData (int dia_p, int mes_p, int ano_p){

        this.dia = dia_p;
        this.mes = mes_p;
        this.ano = ano_p;

        this.validar_Data();
    }

    public boolean compararData (Data d2) {

        String v1 = this.getData();
        String v2 = d2.getData();

        return v1.equals(v2);
    }
}