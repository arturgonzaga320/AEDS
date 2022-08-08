
// Artur Gonzaga da Silva Gomes
// Desenvolvimento de Sistemas _ COLTEC-UFMG 

#include <stdio.h>
#include <stdlib.h>
#include "listas.h"

typedef uint8_t bool;

typedef struct tree_var_s {

    int info;

    struct tree_var_s* bro;
    struct tree_var_s* son;

}tree_var;

tree_var* tree_var_cria (void);

bool tree_var_vazia (tree_var* tree_p);
tree_var* tree_var_busca (tree_var* tree_p, int info_p);
tree_var* tree_var_preenche (tree_var* tree_p, int info_p);

tree_var* tree_var_add_bro (tree_var* tree_p, int info_p);
tree_var* tree_var_add_son (tree_var* tree_p, int info_p, int altura);