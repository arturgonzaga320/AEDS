
public class Programa {

    public static void main (String args[]){

	    Casa minha_casa = new Casa();
	    String cor = "Verde";
	    
	    Porta primeira = new Porta();
	    Porta segunda= new Porta();
	    Porta terceira= new Porta();


	    minha_casa.pintar (cor);
	    minha_casa.adicionar_porta(primeira);
	    minha_casa.adicionar_porta(segunda);
	    minha_casa.adicionar_porta(terceira);

	    minha_casa.porta[0].fechar();
	    minha_casa.porta[1].abrir();
	    minha_casa.porta[2].fechar();

	    System.out.println("- - - - - - - - - - - - - - - - - - -");
	    System.out.println("Cor da casa: " + minha_casa.cor);
	    System.out.println("Portas que estão abertas: " + minha_casa.quantasPortasEstaoAbertas());
	    System.out.println("Total de portas da casa: " + minha_casa.total_portas());
	    System.out.println("- - - - - - - - - - - - - - - - - - -");


    }
}
