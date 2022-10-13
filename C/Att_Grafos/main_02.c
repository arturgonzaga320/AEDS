
// Atividade de Grafos ( 02 )
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

	int n_vertices = 4;
	lista_t* valores = lst_cria();

	grafo* pontes_Konigsberg = grafo_cria(n_vertices);
	grafo* i_pointer;

	// Vértices 'a','b','c' e 'd' 
	for (int i = 100; i > 96; i--)	valores = lst_insere(valores, i);

	pontes_Konigsberg = grafo_insere_vtx(pontes_Konigsberg, valores);

	grafo_nao_ordenado(pontes_Konigsberg, 97,100);
	grafo_nao_ordenado(pontes_Konigsberg, 98,100);
	grafo_nao_ordenado(pontes_Konigsberg, 99,100);

	for (int i = 0; i < 2;i++)	grafo_nao_ordenado(pontes_Konigsberg, 97, 98);
	for (int i = 0; i < 2;i++)	grafo_nao_ordenado(pontes_Konigsberg, 98,99);

	grafo_imprime(pontes_Konigsberg);
	printf("\n");

	for (i_pointer = pontes_Konigsberg; i_pointer != NULL; i_pointer = i_pointer->next) {

		int grau = grafo_obter_grau(i_pointer, i_pointer->vtx_adj->info);
		printf("V%crtice %c tem grau %d\n", 130, i_pointer->vtx_adj->info, grau);
	}

	free(valores);
	grafo_libera(pontes_Konigsberg);

	return SUCESSO;
}
