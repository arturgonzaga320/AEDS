
// Artur Gonzaga da Silva Gomes
// Desenvolvimento de Sistemas - COLTEC-UFMG

// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "tree_var.h"

// Constantes
#define SUCESSO 0

int main (int argc, char** argv) {

	tree_var* tree_teste = tree_var_cria ();
	
	tree_teste = tree_var_preenche (tree_teste, 0);
	tree_teste = tree_var_add_son (tree_teste, 11);

	for (int i = 0; i < 4; i++) tree_teste->son = tree_var_add_bro (tree_teste->son,i);

	tree_var* i_pointer = tree_teste->son->bro;
	i_pointer = tree_var_add_son (i_pointer, 30);
	i_pointer->son = tree_var_add_bro (i_pointer->son, 35);

	for (int i = 0; i < 2; i++) i_pointer = tree_var_add_bro (i_pointer,i);

	tree_var_libera (tree_teste);

	return SUCESSO;
}
