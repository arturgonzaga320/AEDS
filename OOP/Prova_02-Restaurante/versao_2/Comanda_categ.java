// Trabalho Final de AEDS: Restaurante Buchinho Cheio
// Artur Gonzaga da Silva Gomes - 203A

import java.util.Scanner;

public class Comanda_categ extends Comanda {

	private String categoria;

	// Getter
	public String getCategoria()					{ return this.categoria;}

	// Setter
	public void setCategoria(String cate_p)			{ this.categoria = cate_p;}

	@Override
    public void listar_Consumo(int n_pessoas,Scanner scan) { 

		System.out.println("_________________________________");
		System.out.print(this.categoria.toUpperCase()+ this.consumo);

		System.out.println("_________________________________");
		System.out.printf ("Gastos com %s: R$ %.2f\n", this.categoria.toLowerCase(), this.valor);
	} 
}
