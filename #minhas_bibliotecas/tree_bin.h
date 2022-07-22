#include <stdio.h>
#include <stdint.h>

#define VERDADEIRO 1
#define FALSO !VERDADEIRO

typedef uint8_t bool; 


typedef struct tree_bin_s{
	
	char info;

	struct tree_bin_s* son_dir;
	struct tree_bin_s* son_esq;

}tree_bin;

tree_bin* tree_bin_cria (void);

bool tree_bin_vazia (tree_bin* tree_p);

tree_bin* tree_bin_insere_prior (tree_bin* tree_p, char info_p);

tree_bin* tree_bin_insere_dir (tree_bin* tree_p, char info_p);

tree_bin* tree_bin_insere_esq (tree_bin* tree_p, char info_p);

void tree_bin_imprime_preOrdem (tree_bin* tree_p); // preOrdem: raiz, esq, dir;

void tree_bin_imprime_simOrdem (tree_bin* tree_p); // simOrdem: esq, raiz, dir;

void tree_bin_imprime_posOrdem (tree_bin* tree_p); // posOrdem: esq, dir, raiz;

void tree_bin_libera (tree_bin* tree_p);
