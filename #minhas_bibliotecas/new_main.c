
// Agosto, 2022 
// new_main.c, Artur Gonzaga da Silva Gomes
// Desenvolvimento de Sistemas - COLTEC UFMG

// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"

// Constantes
#define SUCESS0 0
#define VERDADEIRO 1 // 1 == 1
#define FALSO 0 // !VERDADEIRO


// main
int main (int argc, char** argv) {

    int n_vertices = 4;
	lista_t* valores = lst_cria();

	grafo* pontes_Konigsberg = grafo_cria(n_vertices);
	grafo* i_pointer;

	// Vertices 'a','b','c' e 'd' 
	for (int i = 100; i > 96; i--)	valores = lst_insere(valores, i);

	pontes_Konigsberg = grafo_insere_vtx(pontes_Konigsberg, valores);
	free(valores);

	grafo_nao_ordenado(pontes_Konigsberg, 97,100);
	grafo_nao_ordenado(pontes_Konigsberg, 98,100);
	grafo_nao_ordenado(pontes_Konigsberg, 99,100);

	for (int i = 0; i < 2;i++)	grafo_nao_ordenado(pontes_Konigsberg, 97, 98);
	for (int i = 0; i < 2;i++)	grafo_nao_ordenado(pontes_Konigsberg, 98,99);

	grafo_imprime(pontes_Konigsberg);
	printf("\n");

    guia* teste = guia_cria (pontes_Konigsberg, n_vertices, 98);
    guia_imprime (teste, n_vertices);

	tree_var* anda = grafo_bfs(pontes_Konigsberg, teste);
    guia_imprime (teste, n_vertices);

	grafo_libera(pontes_Konigsberg);
	guia_libera(teste);

    return SUCESS0;
}
