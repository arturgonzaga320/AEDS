
public class Estatistica {

	// public static int [] quicksort ( int vetor[], int tam_vetor) {

	public static float calcular_media (int vetor[]) {

		float soma = 0;

		for (int i = 0; i < vetor.length; i++) {

			soma += vetor[i];
		}

		return (soma/vetor.length);
	}

	public static void insertionSort(int[] vetor) {
		
		int i, j, key;

		for (j = 1; j < vetor.length; j++) {
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
	}

	public static float calcular_mediana (int vetor[]) {

		float mediana;
		insertionSort(vetor);

		System.out.println ("\nValores do vetor:");

		for ( int j = 0; j < vetor.length; j++) System.out.print (vetor[j] + " "); 
		System.out.println();

		if (vetor.length % 2 == 0) {

			int aux [] = new int [2];
			aux[0] = vetor [vetor.length/2];
			aux[1] = vetor [(vetor.length/2) - 1];

			mediana = Estatistica.calcular_media (aux);
		}
		else {

			int i;
			for (i = 1; (2 * i)+ 1 != vetor.length; i++);

			mediana = vetor[i-1];
		}

		return mediana;
	}

	private static boolean verificar_repeticao (int vetor[], int x) {

		boolean repetido = false;

		for (int i = 0; i < x && repetido == false; i++) {

			if ( vetor[x] == vetor [i]) {

				repetido = true;
			}
		}

		return repetido;
	}

	public static int calcular_moda (int vetor[]){


		int k = 0, n_variaveis = 0;
		boolean teste;

		for (int i = 0; i < vetor.length; i++) {

			teste = Estatistica.verificar_repeticao(vetor,i);
			if (teste == false) n_variaveis ++;
		}
		
		// Linha para valores, colunas para ocorrencias
		int [][] vetor_moda = new int [n_variaveis] [2];
		//  n_variaveis linhas, 2 colunas

		for (int i = 0; i < vetor.length; i++) {

			teste = Estatistica.verificar_repeticao(vetor,i);

			if (teste == false) {
			
				vetor_moda[k][0] = vetor[i]; 
				k++;
			}
		}

		System.out.println();

		for (int i = 0; i < vetor.length; i++) {

			for ( k = 0; k < vetor.length; k++) {

				if (vetor_moda[k][0] == vetor[i]) {

					vetor_moda[k][1] ++;
					k = vetor.length + 1;
				}
			}
		}

		int top = 0;
		for (int i = 1; i < n_variaveis; i++){

			if (vetor_moda[top][1] < vetor_moda[i][1]) top = i;
		}

		return vetor_moda[top][0];
	}

}
