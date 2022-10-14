#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "tree_bin.h"

#define VERDADEIRO 1 
#define FALSO !VERDADEIRO

#define N_FILHOS_FOLHA 0
#define N_FILHOS_NOS_1 1
#define N_FILHOS_NOS_2 2

#define SUCESSO 0

typedef uint8_t bool;

int tree_bin_nFilhos(tree_bin* tree_p) { 
	
	int n_filhos = 0;
	
	if (tree_bin_vazia(tree_p) == FALSO) {
	
		if (tree_p->son_esq != NULL) n_filhos++;
		if (tree_p->son_dir != NULL) n_filhos++;
	}

	return n_filhos;
}

int tree_bin_nMem (tree_bin* tree_p, int mem_filhos) {

	int mem = 0;

	if (tree_bin_vazia(tree_p) == FALSO) {

		mem += tree_bin_nMem(tree_p->son_esq, mem_filhos);
		mem += tree_bin_nMem(tree_p->son_dir, mem_filhos);

		if (tree_bin_nFilhos(tree_p) == mem_filhos) mem++;
	}

	return mem;
}

int main (int argc, char** argv) {

	tree_bin* tree_p = tree_bin_cria();
	tree_bin* ponteiro;
	tree_bin* aux;

	for (char i = 100; i > 96; i--)		tree_p = tree_bin_insere_prior(tree_p, i);
	for (char i = 101; i < 104; i++)	tree_p = tree_bin_insere_prior(tree_p, i);

	ponteiro = tree_p;

	while (ponteiro->son_esq != NULL) {

		ponteiro = ponteiro->son_esq; 
	}

	aux = ponteiro;

	ponteiro = tree_bin_insere_dir(ponteiro, 97);
	aux = tree_bin_insere_esq(aux, 97);

	printf("\n\tA %crvore tem:", 160);

	printf("\n\t> %d folha(s)", tree_bin_nMem(tree_p, N_FILHOS_FOLHA) );
	printf("\n\t> %d n%c(s) com 1 filho", tree_bin_nMem(tree_p, N_FILHOS_NOS_1), 162 );
	printf("\n\t> %d n%c(s) com 2 filhos\n\n", tree_bin_nMem(tree_p, N_FILHOS_NOS_2), 162 );

	tree_bin_libera(tree_p);

	return SUCESSO;
}