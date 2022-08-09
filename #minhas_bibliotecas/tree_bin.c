// Julho, 2022
// tree_bin.c - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "tree_bin.h"

#define VERDADEIRO 1 // (1 == 1)
#define FALSO 0 // !VERDADEIRO

typedef uint8_t bool;

// pré ordem: raiz, esq, dir;
// ordem simetrica: esq, raiz, dir;
// pós ordem: esq, dir, raiz;

tree_bin* tree_bin_cria(void) {
	
	return NULL;
}

bool tree_bin_vazia (tree_bin* tree_p) {

	return (tree_p == NULL) ? VERDADEIRO:FALSO;
}

tree_bin* tree_bin_insere_prior(tree_bin* tree_p, char info_p){

	if (tree_bin_vazia(tree_p) == VERDADEIRO ){

		tree_bin* new_tree = (tree_bin*) malloc ( sizeof (tree_bin) );
		
		new_tree->info = info_p;
		new_tree->son_dir = NULL;
		new_tree->son_esq = NULL;

		return new_tree;
	}

	else if (info_p < tree_p->info){

		tree_p->son_esq = tree_bin_insere_prior(tree_p->son_esq,info_p);
	}

	else{

		tree_p->son_dir = tree_bin_insere_prior(tree_p->son_dir,info_p);
	}

	return tree_p;
}

tree_bin* tree_bin_insere_dir(tree_bin* tree_p, char info_p){

	if (tree_bin_vazia(tree_p) == VERDADEIRO ){


		tree_bin* new_tree = (tree_bin*)malloc(sizeof(tree_bin));

		new_tree->info = info_p;
		new_tree->son_dir = NULL;
		new_tree->son_esq = NULL;

		return new_tree;
	}
	else {

		tree_p->son_dir = tree_bin_insere_prior(tree_p->son_dir,info_p);
	}

	return tree_p;
}

tree_bin* tree_bin_insere_esq(tree_bin* tree_p, char info_p){

	if (tree_bin_vazia(tree_p) == VERDADEIRO ){

		tree_bin* new_tree = (tree_bin*)malloc(sizeof(tree_bin));

		new_tree->info = info_p;
		new_tree->son_dir = NULL;
		new_tree->son_esq = NULL;

		return new_tree;
	}
	else {

		tree_p->son_esq = tree_bin_insere_prior(tree_p->son_esq,info_p);
	}
	
	return tree_p;
}

void tree_bin_imprime_preOrdem (tree_bin* tree_p) {

	// pré ordem: raiz, esq, dir;
	
	if (tree_bin_vazia(tree_p) == FALSO){
		
		printf ("%c", tree_p->info);
		tree_bin_imprime_preOrdem ( tree_p->son_esq );
		tree_bin_imprime_preOrdem( tree_p->son_dir );	
	}
}

void tree_bin_imprime_simOrdem(tree_bin* tree_p) {

	// ordem simetrica: esq, raiz, dir

	if (tree_bin_vazia(tree_p) == FALSO) {

		tree_bin_imprime_simOrdem(tree_p->son_esq);
		printf("%c", tree_p->info);
		tree_bin_imprime_simOrdem(tree_p->son_dir);
	}
}

void tree_bin_imprime_posOrdem (tree_bin* tree_p) {
	
	// pós ordem: esq, dir, raiz;

	if (tree_bin_vazia(tree_p) == FALSO){
		
		tree_bin_imprime_posOrdem( tree_p->son_esq );
		tree_bin_imprime_posOrdem( tree_p->son_dir );
		
		printf ("%c", tree_p->info);
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
