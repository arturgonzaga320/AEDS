public class Casa {

    public String cor;
    private int totalDePortas = 0;
    public Porta[] porta = new Porta[0];

    
    public void pintar(String s){

        this.cor = s;
    }

    public int quantasPortasEstaoAbertas(){

        int n_abertas = 0;

        for (int i = 0; i < this.totalDePortas; i++){

           if (this.porta[i].mostrar_estado() == true) n_abertas ++;
        }

        return n_abertas;
    }
   
    public void adicionar_porta (Porta p) {

        this.totalDePortas ++;

	Porta[] aux = new Porta [this.totalDePortas];


	if ( (this.totalDePortas - 1 ) > 0 ) {

		for (int i = 0; i < this.totalDePortas - 1; i++){

			aux[i] = this.porta[i];
		}
	}

	aux[this.totalDePortas - 1] = p;
	aux[this.totalDePortas - 1].abrir();

        this.porta = aux;
    }

    public int total_portas() {

        return this.totalDePortas;
    }
    
}
