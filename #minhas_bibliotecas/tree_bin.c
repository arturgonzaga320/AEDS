#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "tree_bin.h"

#define VERDADEIRO 1 
#define FALSO !VERDADEIRO

typedef uint8_t bool;

// pré ordem: raiz, esq, dir;
// ordem simetrica: esq, raiz, dir;
// pós ordem: esq, dir, raiz;

tree_bin* tree_bin_cria(void) {
	
	return NULL;
}

bool tree_bin_vazia (tree_bin* tree_p) {

	/*if (tree_p == NULL) {
	
		return VERDADEIRO;
	}
	
	else return FALSO;
	*/
	return (tree_p == NULL) ? VERDADEIRO:FALSO;
}

tree_bin* tree_bin_insere(tree_bin* tree_p, char info_p){

	if (tree_bin_vazia(tree_p) == VERDADEIRO ){

		tree_p = tree_bin_cria();

		tree_p->info = info_p;
		tree_p->son_dir = NULL;
		tree_p->son_esq = NULL;
	}

	else if (info_p < tree_p->info){

		tree_p->son_esq = tree_bin_insere(tree_p->son_esq,info_p);
	}

	else{

		tree_p->son_dir = tree_bin_insere(tree_p->son_dir,info_p);
	}

	return tree_p;
}

void tree_bin_imprime_preOrdem (tree_bin* tree_p) {

	// pré ordem: raiz, esq, dir;
	
	if (tree_bin_vazia(tree_p) == FALSO){
		
		printf ("%d", tree_p->info);
		tree_bin_imprime ( tree_p->son_esq );
		tree_bin_imprime ( tree_p->son_dir );	
		
	}
}

void tree_bin_imprime_simOrdem (tree_bin* tree_p); {

	// ordem simetrica: esq, raiz, dir;
	
	if (tree_bin_vazia(arv_cp) == FALSO){

		tree_bin_imprime ( tree_p->son_esq );
		printf ("%d", tree_p->info);
		tree_bin_imprime ( tree_p->son_dir );
	}
}

void tree_bin_imprime_posOrdem (Arv_t* tree_p) {
	
	// pós ordem: esq, dir, raiz;

	if (tree_bin_vazia(tree_p) == FALSO){
		
		tree_bin_imprime ( tree_p->son_esq );
		tree_bin_imprime ( tree_p->son_dir );	
		
		printf ("%d", tree_p->info);
	}
}

void tree_bin_libera (tree_bin* tree_p) {

	// pos ordem - obrigatoriamente -

	if (tree_bin_vazia(tree_p) == FALSO){
		
		tree_bin_libera ( tree_p->son_esq );
		tree_bin_libera ( tree_p->son_dir );	

		free (tree_p);
	}

}
