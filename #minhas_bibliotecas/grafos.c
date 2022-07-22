// Julho, 2022
// listas.c - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"

grafo* grafo_cria(int n_vtx) {

	grafo* grafo_aux = (grafo*) malloc(sizeof(grafo));
	grafo_aux->vtx_adj = lst_cria();

	if (n_vtx > 1) {
		n_vtx--;
		grafo_aux->next = grafo_cria(n_vtx);
	}
	else grafo_aux->next = NULL;

	return grafo_aux;
}

grafo* grafo_insere(grafo* grafo_p, int vtx, int info_p) {

	
	grafo* grafo_aux = (grafo*) malloc (sizeof(grafo));
	grafo_aux->vtx_adj = (lista_t*)malloc(sizeof(lista_t));

	grafo_aux->vtx_adj = lst_insere(grafo_aux->vtx_adj, info_p);

	return grafo_aux;

}


grafo* grafo_insere_adj(grafo* grafo_p, int vtx, int adj) {

	grafo* i_pointer = grafo_p;

	while ((i_pointer->vtx_adj->info != vtx) && i_pointer != NULL) {

		i_pointer = i_pointer->next;
	}

	if (i_pointer != NULL) {

		i_pointer->vtx_adj = lst_insere(i_pointer->vtx_adj, adj);
		return i_pointer;
	}

	printf("Vertex inexistente");
	return grafo_p;
}

void grafo_libera(grafo* gra_p) {

	grafo* i_pointer = gra_p;

	while (i_pointer != NULL) {

		grafo* tmp = i_pointer->next;

		lst_libera(i_pointer->vtx_adj);
		free(i_pointer);

		i_pointer = tmp;
	}
}
