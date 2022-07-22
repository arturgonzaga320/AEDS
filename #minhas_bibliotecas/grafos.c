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
		grafo_aux->next = grafo_cria (n_vtx);
	}
	else grafo_aux->next = NULL;

	return grafo_aux;
}

grafo* grafo_insere_vtx (grafo* grafo_p,lista_t* valores) {

	if (grafo_p->next != NULL) {

		grafo_p->next = grafo_insere_vtx(grafo_p->next, valores->prox);
	}

	grafo_p->vtx_adj = lst_insere(grafo_p->vtx_adj, valores->info);
	valores = valores->prox;

	return grafo_p;
}

grafo* grafo_busca(grafo* grafo_p, int vtx_p) {

	grafo* i_pointer = grafo_p;

	while ((i_pointer->vtx_adj->info != vtx_p) && (i_pointer != NULL) ) {

		i_pointer = i_pointer->next;
	}
	
	if (i_pointer == NULL) printf ("Vertex %c inextistente", vtx_p);

	return i_pointer;
}

grafo* grafo_insere_adj(grafo* grafo_p, int vtx, int adj) {

	if (grafo_busca(grafo_p, vtx) != NULL) {

		grafo* grafo_aux = grafo_busca(grafo_p, vtx);

		grafo_aux->vtx_adj = lst_pilha_insere(grafo_aux->vtx_adj, adj);
	}

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
