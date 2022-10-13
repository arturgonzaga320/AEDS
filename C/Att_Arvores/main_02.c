#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "tree_bin.h"

#define VERDADEIRO 1 
#define FALSO !VERDADEIRO

#define SUCESSO 0

typedef uint8_t bool;

tree_bin* tree_bin_insere_PRIOR(tree_bin* tree_p, char info_p){

	//   (info_param > info_nóAtual) ? 
	// **  vai jogar info_param pra  **  
	//       direita:esquerda

	if (tree_bin_vazia(tree_p) == VERDADEIRO) {

		tree_bin* new_tree = (tree_bin*)malloc(sizeof(tree_bin));

		new_tree->info = info_p;
		new_tree->son_dir = NULL;
		new_tree->son_esq = NULL;

		return new_tree;
	}

	else if (info_p < tree_p->info) {

		tree_p->son_esq = tree_bin_insere_PRIOR(tree_p->son_esq, info_p);
	}

	else {

		tree_p->son_dir = tree_bin_insere_PRIOR(tree_p->son_dir, info_p);
	}

	return tree_p;
}


// int main para testar a função
int main (int argc, char** argv){

	tree_bin* tree_p = tree_bin_cria();

	for (int i = 109; i > 96; i--){
	
		tree_p = tree_bin_insere_PRIOR ( tree_p, i );
	}

	tree_bin_imprime_simOrdem(tree_p);
	tree_bin_libera(tree_p);

	return SUCESSO;
}
