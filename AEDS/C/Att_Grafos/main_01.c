
// Atividade de Grafos ( 01 )
// Artur Gonzaga da Silva Gomes, 203
// Profa. Virgínia Mota

// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"


// Constantes
#define SUCESSO 0

// main
int main(int argc, char** argv) {

	int** matriz;
	int n_vertices;
	lista_t* lista_main = lst_cria();
	grafo* grafo_main, * i_pointer;


	printf("Quantidade de v%crtices do grafo: ", 130);
	scanf("%d", &n_vertices);
	printf("\n");

	matriz = (int**) calloc (n_vertices, sizeof(int*)); // Aloca linhas

	for (int i = 0; i < n_vertices; i++) {

		matriz[i] = (int*)calloc(n_vertices, sizeof(int)); // Aloca colunas
	}

	for (int i = 0; i < n_vertices; i++) {

		int n_aux, aux;
		printf("> Sobre o v%crtice %d\n\n", 130, i + 1);

		printf("\tQuantos v%crtices que o v%crtice %d est%c orientado: ", 130, 130, i+1, 160);
		scanf("%d", &n_aux);

		if (n_aux > 0) {

			printf("\tV%crtice que o v%crtice %d est%c orientado (ex.: 2 5 9): ", 130, 130, i + 1, 160);

			for (int j = 0; j < n_aux; j++) {

				scanf("%d", &aux);
				if (aux <= n_vertices) matriz[i][aux - 1] ++;
			}
		}
		printf("\n");
	}

	grafo_main = grafo_cria(n_vertices);
	for (int i = (97 + n_vertices); i > 96 ; i--) lista_main = lst_insere(lista_main, i);

	grafo_main = grafo_insere_vtx(grafo_main, lista_main);


	// Imprime grafo
	for (int i = 0; i < n_vertices; i++) {

		for (int j = 0; j < n_vertices; j++) {

			if (matriz[i][j] > 0) {

				grafo_main = grafo_insere_adj( grafo_main, (97 + i), (97 + j) );
			}
		}
	}

	grafo_imprime(grafo_main);
	printf("\n");


	// Obtem graus de cada vértice
	for (i_pointer = grafo_main; i_pointer != NULL; i_pointer = i_pointer->next) {

		int grau = grafo_obter_grau(i_pointer, i_pointer->vtx_adj->info);
		printf("V%crtice %c tem grau %d\n", 130, i_pointer->vtx_adj->info, grau);
	}


	// Libera memória
	for (int i = 0; i < n_vertices; i++) free(matriz[i]);
	free(matriz);

	free(lista_main);
	grafo_libera(grafo_main);

	return SUCESSO;
}
