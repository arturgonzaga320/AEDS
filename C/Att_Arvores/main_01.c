#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "tree_bin.h"

#define VERDADEIRO 1 
#define FALSO !VERDADEIRO

#define SUCESSO 0

typedef uint8_t bool;

void tree_bin_imprime_PREordem (tree_bin* tree_p) {

	// pré ordem: raiz, esq, dir;
	
	if (tree_bin_vazia(tree_p) == FALSO){
		
		printf ("%c", tree_p->info);
		tree_bin_imprime_PREordem( tree_p->son_esq );
		tree_bin_imprime_PREordem( tree_p->son_dir );	
	}
}

void tree_bin_imprime_SIMordem (tree_bin* tree_p) {

	// ordem simetrica: esq, raiz, dir;
	
	if (tree_bin_vazia(tree_p) == FALSO){

		tree_bin_imprime_SIMordem( tree_p->son_esq );
		printf ("%c", tree_p->info);
		tree_bin_imprime_SIMordem( tree_p->son_dir );
	}
}

void tree_bin_imprime_POSordem (tree_bin* tree_p) {
	
	// pós ordem: esq, dir, raiz;

	if (tree_bin_vazia(tree_p) == FALSO){
		
		tree_bin_imprime_posOrdem( tree_p->son_esq );
		tree_bin_imprime_posOrdem( tree_p->son_dir );
		
		printf ("%c", tree_p->info);
	}
}

// int main utilizado para testar as funções
int main (int argc, char** argv) {


	tree_bin* tree_p = tree_bin_cria();

	for (char i = 100; i >96 ; i--) {
		
		tree_p = tree_bin_insere_prior(tree_p,i);
	}

	for (char i = 101; i < 104; i++) {

		tree_p = tree_bin_insere_prior(tree_p, i);
	}

	tree_bin_imprime_PREordem ( tree_p );
	printf("\n");

	tree_bin_imprime_SIMordem ( tree_p );
	printf("\n");

	tree_bin_imprime_posOrdem ( tree_p );
	printf("\n");

	tree_bin_libera ( tree_p );

	return SUCESSO;
}