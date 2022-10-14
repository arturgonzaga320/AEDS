
public class Programa {

	public static void main (String args[]){

		int vetor_t [] = new int [9];

		vetor_t[0] = 2;
		vetor_t[1] = 4;
		vetor_t[2] = 2;
		vetor_t[3] = 5;
		vetor_t[4] = 9;
		vetor_t[5] = 4;
		vetor_t[6] = 2;
		vetor_t[7] = 4;
		vetor_t[8] = 4;
		
		System.out.println ("\nValores do vetor:");
		for ( int j = 0; j < vetor_t.length; j++){

			//vetor_t[j] = j + 1;
			System.out.print (vetor_t[j] + " ");

		}

		// Antes de fazer essas medias, tem que ordenar o vetor !!
		float media = Estatistica.calcular_media(vetor_t);
		float mediana = Estatistica.calcular_mediana(vetor_t);
		int moda = Estatistica.calcular_moda (vetor_t);

		System.out.println ("\n\nMedia do vetor: " + media);
		System.out.println ("Mediana do vetor: " + mediana);
		System.out.println ("Mediana do vetor: " + moda + "\n");
	}

}
