// Junho, 2022
// filas.c - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "filas.h"

#define VERDADEIRO 0
#define FALSO 1
#define ERRO 1

fila_lst* fila_lst_cria(){

	fila_lst* fila_aux;
	fila_aux = (fila_lst*) malloc (sizeof(fila_lst));

	fila_aux->inicio = NULL;
	fila_aux->fim = NULL;

	return fila_aux;
}

bool fila_lst_vazia (fila_lst* fila_p){
	
	if (fila_p->inicio == NULL){
		
		return VERDADEIRO;
	}
	else { return FALSO; }
}

void fila_lst_insere (fila_lst* fila_p, int info_param){

	lista_t* novo_elem;
	novo_elem = (lista_t*) malloc (sizeof(lista_t));

	novo_elem->info = info_param;
	novo_elem->prox = NULL;

	if ( fila_lst_vazia(fila_p) == VERDADEIRO ){

		fila_p->inicio = novo_elem;
		fila_p->fim = novo_elem;
	}
	else { 

		lista_t* i_ponteiro;
		
		for (i_ponteiro = fila_p->inicio; i_ponteiro->prox != NULL; i_ponteiro = i_ponteiro->prox);

		i_ponteiro->prox = novo_elem;
		fila_p->fim = novo_elem; 
	}

}

int fila_lst_retira (fila_lst* fila_p){
	
	if ( fila_lst_vazia(fila_p) == VERDADEIRO ) {

		return ERRO; // Ao retornar para main, pedir para verificar ERRO
	}

	int info_removida = fila_p->inicio->info;

	lista_t* remover_elem;
	remover_elem = (lista_t*) malloc (sizeof(lista_t));
	remover_elem = fila_p->inicio;

	fila_p->inicio = fila_p->inicio->prox;
	
	free (remover_elem);

	if (fila_p->inicio == NULL) {
		
		fila_p->fim = NULL;
	}
	
	return info_removida;
}

void fila_lst_inverte(fila_lst* fila_p){
	
	if (fila_lst_vazia(fila_p) == VERDADEIRO) {

		return;
	}

	int i = 0, n_elementos = 1;
	int* vetor_valores;
 		
	for (lista_t* i_ponteiro = fila_p->inicio; i_ponteiro->prox != NULL; i_ponteiro = i_ponteiro->prox) { 
		
		n_elementos++;
	}

	vetor_valores = (int*)malloc(sizeof(int) * n_elementos);

	for (lista_t* i_ponteiro = fila_p->inicio; i_ponteiro != NULL; i_ponteiro = i_ponteiro->prox) {

		vetor_valores[i]=i_ponteiro->info;
		i++;
	}

	while (fila_lst_vazia(fila_p) == FALSO) {
		fila_lst_retira(fila_p);
	}

	for (i = (n_elementos-1); i >= 0; i--) {

		fila_lst_insere(fila_p, vetor_valores[i]);
	}

	free(vetor_valores);
}

lista_t* fila_lst_busca(fila_lst* fila_p, int info_alvo){
	
	lista_t* i_ponteiro;
	
	for (i_ponteiro = fila_p->inicio; i_ponteiro != NULL; i_ponteiro = i_ponteiro->prox){
		
		if (i_ponteiro->info == info_alvo){
			
			return i_ponteiro;
		}
	}

	return NULL;
}

void fila_lst_imprime(fila_lst* fila_p){
	
	lista_t* i_ponteiro;
	
	for (i_ponteiro = fila_p->inicio; i_ponteiro != NULL; i_ponteiro = i_ponteiro->prox){
		
		printf("\t%d\n",i_ponteiro->info);
	}

	free(i_ponteiro);
}

void fila_lst_libera(fila_lst* fila_p) {

	lista_t* i_ponteiro = fila_p->inicio;

	while (i_ponteiro != NULL) {
		
		lista_t* temp = i_ponteiro->prox; 
		free(i_ponteiro);
		i_ponteiro = temp;
	}
	
	free(fila_p);
}