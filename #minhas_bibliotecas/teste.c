#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"

#define SUCESSO 0

int main(int argc, char** argv) {

	lista_t* valores = lst_cria();

	for (int i = 97; i < 101; i++)	valores = lst_insere(valores, i);

	grafo* grafo_teste = grafo_cria(4);
	
	grafo_teste = grafo_insere_vtx(grafo_teste, valores);
	grafo_teste = grafo_insere_adj(grafo_teste, 99, 65);
	grafo_teste = grafo_insere_adj(grafo_teste, 99, 69);
	grafo_teste = grafo_insere_adj(grafo_teste, 100, 97);

	free(valores);
	grafo_libera(grafo_teste);
	return SUCESSO;
}