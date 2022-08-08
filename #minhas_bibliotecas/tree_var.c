// Artur Gonzaga da Silva Gomes
// Desenvolvimento de Sistemas, COLTEC-UFMG

#include <stdio.h>
#include <stdlib.h>
#include "tree_var.h"

#define VERDADEIRO 1 // (1 == 1)
#define FALSO 0 // !VERDADEIRO

tree_var* tree_var_cria (void) { 

	return NULL; 
}

bool tree_var_vazia ( tree_var* tree_p ) {

	if (tree_p == NULL) return VERDADEIRO;	
	else return FALSO;
}

tree_var* tree_var_preenche (tree_var* tree_p, int info_p) {

	// Aloca
	tree_var* tree_aux = (tree_var*) malloc (sizeof (tree_var));

	// Preenche
	tree_aux->info = info_p;
	tree_aux->bro = NULL;
	tree_aux->son = NULL;

	return tree_aux;
}

tree_var* tree_var_busca (tree_var* tree_p, int info_p ) {

	tree_var* i_pointer = tree_p;
	
	if (i_pointer == NULL) {

		return NULL; // Elemento nao encontrado
	}

	
	if (i_pointer->info != info_p ) { 

		if (i_pointer->bro != NULL) {
			
			tree_var_busca (i_pointer->bro, info_p);	
		}


		if (i_pointer->son != NULL) {
			
			tree_var_busca (i_pointer->son, info_p);	
		}
	}

	return i_pointer;
}

tree_var* tree_var_add_bro ( tree_var* tree_p, int info_p) {

	tree_var* i_pointer = tree_p;
	
	if (tree_var_vazia (i_pointer) == VERDADEIRO ) {

		i_pointer = tree_var_preenche(i_pointer, info_p);
		
		return i_pointer;
	}

	else {
	
		while (i_pointer->bro != NULL) i_pointer = i_pointer->bro;

		tree_var* tree_aux = tree_var_preenche (tree_aux, info_p);

		i_pointer->bro = tree_aux;
	}
	
	return tree_p;
}



tree_var* tree_var_add_son ( tree_var* tree_p, int info_p, int altura) {

	tree_var* i_pointer = tree_p;
	
	if (tree_var_vazia (i_pointer) == VERDADEIRO ) {

		i_pointer = tree_var_preenche (i_pointer, info_p);

		return i_pointer;
	}

	if ( altura != 0 ) {
	
		altura --;
		tree_var_add_son (i_pointer->son, info_p, altura);
	}
}
