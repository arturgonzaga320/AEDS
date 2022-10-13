#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "tree_bin.h"

#define VERDADEIRO 1 
#define FALSO !VERDADEIRO
#define TAM_VETOR 26

#define SUCESSO 0

typedef uint8_t bool;

int* tree_bin_histogram (tree_bin* tree_p, int* histo) {
	
	int add_in;

	if (tree_bin_vazia(tree_p) == FALSO) {

		tree_bin_histogram (tree_p->son_esq, histo);
		tree_bin_histogram (tree_p->son_dir, histo);

		if (tree_p->info < 97) tree_p->info += 32;
		add_in = tree_p->info - 97;

		if (add_in >= 0 && add_in <= 25) histo[add_in]++;
	} 

	return histo;
}

int main(int argc, char** argv) {

	int* histo = (int*)calloc( TAM_VETOR, sizeof (int));
	tree_bin* tree_p = tree_bin_cria();

	tree_bin* ponteiro;
	tree_bin* aux;

	for (char i = 100; i > 96; i--)		tree_p = tree_bin_insere_prior(tree_p, i);
	for (char i = 101; i < 104; i++)	tree_p = tree_bin_insere_prior(tree_p, i);

	ponteiro = tree_p;

	while (ponteiro->son_esq != NULL) ponteiro = ponteiro->son_esq;

	aux = ponteiro;

	ponteiro = tree_bin_insere_dir(ponteiro, 97);
	aux = tree_bin_insere_esq(aux, 97);
	
	for (int i = 3; i > 0; i--) {
		aux = tree_bin_insere_dir(aux, 122);
	}

	histo = tree_bin_histogram(tree_p, histo);

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	printf("\n\tHISTOGRAMA DE %cRVORE BIN%cRIA\n", 181, 181);
	printf("\t____________________________________________________\n");

	// Impressão normal

	printf("\n\t> Impress%co normal:\n\n", 198);

	for (int i = 0; i < TAM_VETOR; i++) {

		printf("\t%c ", 97 + i);

		for (int j = histo[i]; j > 0; j--) printf("* ");

		printf("\n");
	}

	printf("\t____________________________________________________\n");

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	// Impressão desafio

	printf("\n\t> Impress%co desafio:\n\n", 198);
	int dominante = histo[0];

	for (int i = 1; i < TAM_VETOR; i++) {

		if (dominante < histo[i]) dominante = histo[i];
	}

	printf("\t");

	for (int i = dominante; i > 0; i--) {
	
		for (int j = 0; j < TAM_VETOR; j++) {
			
			if (histo[j] >= i) printf("* ");
			else printf ("  ");
		}
		printf("\n\t");
	}
	
	for (int i = 0; i < TAM_VETOR; i++) printf ("%c ", (97 + i) );

	printf("\n\n\n");

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	free(histo);
	tree_bin_libera (tree_p);

	return SUCESSO;
}