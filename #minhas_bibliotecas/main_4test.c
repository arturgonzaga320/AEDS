
// Artur Gonzaga da Silva Gomes
// Desenvolvimento de Sistemas - COLTEC-UFMG

#include <stdio.h>
#include <stdlib.h>

#include "tree_var.h"

#define SUCESSO 0

int main (int argc, char** argv) {

	tree_var* tree_teste = tree_var_cria ();
	
	for (int i = 0; i < 10; i++) {

		tree_teste = tree_var_add_bro (tree_teste, i);
	}
	

	for (tree_var* i_pointer = tree_teste; i_pointer != NULL; i_pointer = i_pointer->bro) {

		printf("%d\n", i_pointer->info);			
	}

	return SUCESSO;
}
