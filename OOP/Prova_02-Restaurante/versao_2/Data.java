// Trabalho Final de AEDS: Restaurante Buchinho Cheio
// Artur Gonzaga da Silva Gomes - 203A

import java.util.Scanner;

public class Data {
    
    private int dia;
    private int mes;
    private int ano;
    private Comanda conta = new Comanda(); 
    private Cliente[] pessoas = new Cliente[0];
    
    // Getters
    public Comanda getConta()               { return this.conta;}
    public Cliente[] getPessoas()           { return this.pessoas;}

    public String getData() {

        String data_p = this.dia + "/" + this.mes + "/" + this.ano;
        return data_p;
    }

    // Setters
    public void setConta(Comanda n_conta)               { this.conta = n_conta;}
    public void setPessoas(Cliente[] n_pessoas)         { this.pessoas = n_pessoas;}

    public void setData(int dia_p, int mes_p, int ano_p) {

        this.dia = dia_p;
        this.mes = mes_p;
        this.ano = ano_p;

        this.validar_Data();
    }

    // Contructors
    public Data (/* Sem params */)                      { /* Sem mods */ }
    public Data (int dia_p, int mes_p, int ano_p)       { this.setData(dia_p, mes_p, ano_p);}

    public void validar_Data() {

        if (this.dia > 28 && this.mes == 2) {

            this.mes +=this.dia / 30;
            this.dia = this.dia - 28;

            this.validar_Data ();
        }
        
        if (this.dia > 30) {

            this.mes +=this.dia / 30;
            if (this.mes == 2) this.dia = this.dia % 28;
            else this.dia = this.dia % 30;

            this.validar_Data ();
        }

        if (this.mes > 12) {

            this.ano +=   this.mes / 12;
            this.mes =    this.mes % 12;

            this.validar_Data ();
        }

    }

    public void preparar_Comanda(String[] categs){

        this.conta.setComandas_categs(categs);
    }

    public boolean comparar_Data (Data d2) {

        String v1 = this.getData();
        String v2 = d2.getData();
        return v1.equals(v2);
    }    
    
    public Cliente adicionar_Cliente( Scanner scan) {

        System.out.print("> Nome: ");
        String n_p = scan.next();

        System.out.print("> E_mail: ");
        String e_p = scan.next();

        Cliente novo = new Cliente(n_p, e_p);
        return novo;
    }
}
