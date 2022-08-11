
// Artur Gonzaga da Silva Gomes
// Desenvolvimento de Sistemas - COLTEC-UFMG

// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"
#include "tree_var.h"

// Constantes
#define SUCESSO 0
#define VERDADEIRO 1 // 1 == 1
#define FALSO 0 // !VERDADEIRO

grafo* grafo_ini_aux_busca () {

	grafo* search_aux = grafo_cria (4);

	lista_t* lst_aux = lst_cria ();

	lst_aux = lst_insere (lst_aux, 113); // q, lista de vertice a serem explorados
	lst_aux = lst_insere (lst_aux, 99); // c, cor dos vertices
	lst_aux = lst_insere (lst_aux, 98); // b, endereço mais prox da fonte
	lst_aux = lst_insere (lst_aux, 100); // d, distancia da fonte
 
	search_aux = grafo_insere_vtx (grafo_p, lst_aux);
	lst_libera(lst_aux);

	grafo* i_pointer = grafo_busca_vtx(search_aux, 99);
	// Deixa todos os vertices brancos (w)
	for (int i = 0; i < n_vtx, i++ ) {

		i_pointer->vtx_adj = lst_push(i_pointer->vtx_adj, 119);
	}

	grafo* i_pointer = grafo_busca_vtx(search_aux, 98);
	// Deixa todos os vertices indefinos (-1)
	for (int i = 0; i < n_vtx, i++ ) {

		i_pointer->vtx_adj = lst_push(i_pointer->vtx_adj, -1);
	}

	grafo* i_pointer = grafo_busca_vtx(search_aux, 100);
	// Deixa todos os vertices indefinos (-1)
	for (int i = 0; i < n_vtx, i++ ) {

		i_pointer->vtx_adj = lst_push(i_pointer->vtx_adj, -1);
	}

	return search_aux;
}

tree_var* grafo_em_largura (grafo* grafo_p, grafo* search_aux, tree_var* tree_caminhos, int vtx_p) {

	grafo* i_pointer = grafo_busca_vtx(grafo_p, vtx_p);

	for (lista_t* j_pointer = i_pointer->vtx_adj->prox; j_pointer != NULL; j_pointer = j_pointer->prox) {

		grafo* k_pointer = grafo_busca_vtx (search_aux, 113); // Adiciona vertice a lista de grafos a explorar				
		
		// Nao faz sentido repetir o vertice nas listas
		if (lst_busca(k_pointer->vtx_adj->prox, j_pointer->info) != NULL ) { 

			k_pointer->vtx_adj = lst_push (k_pointer->vtx_adj, j_pointer->info);
		}
		
		
		grafo* k_pointer = grafo_busca_vtx (i_pointer, 99); // Altera cor do vertice de branco para cinza
		
		// Nao faz sentido repetir o vertice nas listas
		if (lst_busca(k_pointer->vtx_adj->prox, j_pointer->info) != NULL ) { 

			k_pointer->vtx_adj = lst_push (k_pointer->vtx_adj, j_pointer->info);
		}

	}



	return tree_caminhos;
}

// main
int main (int argc, char** argv) {

	tree_var* tree_caminhos = tree_var_cria();

	/*
	COMENTARIOS DO QUE FAZER

		> Implementar com matriz, ao inver de um grafo em search_aux
	*/



	return SUCESSO;
}
