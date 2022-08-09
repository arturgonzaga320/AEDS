
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

tree_var* grafo_busca_largura (grafo* grafo_p, int n_vtx) {

	tree_var* result = tree_var_cria ();

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

	// Grafo search_aux inicializado, preprar funcao para percorrer 
	// pelos vertices de grafo_p e modificar search_aux

	// Apos estar completamente modificado, 
	// * quando todas os elementos c->prox forem iguais a black (98) *
	// implementar search_aux em uma tree_var e retorna-la

	return result;
}


int main (int argc, char** argv) {

	tree_var ();

	return SUCESSO;
}
