// Agosto, 2022
// listas_adj.c - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "listas_adj.h"

#define VERDADEIRO 1	// 1 == 1
#define FALSO 0			// !VERDADEIRO	
#define ERRO 1

lista_adj* lst_adj_cria(){

	return NULL;
}

bool lst_adj_vazia (lista_adj* lista_p){
	
	if (lista_p == NULL){
		
		return VERDADEIRO;
	}
	else { return FALSO; }
}

lista_adj* lst_adj_insere (lista_adj* lista_p, int info_p, int peso_p){

	lista_adj* novo_elem;
	novo_elem = (lista_adj*)malloc(sizeof(lista_adj));

	novo_elem->info = info_param;
	novo_elem->peso = peso_p;
	novo_elem->prox = lista_p;
	return novo_elem;
}

// Insere como se fosse uma pilha
lista_adj* lst_adj_push(lista_adj* lista_p, int info_p, int peso_p) {

	lista_adj* lista_aux = lista_p;

	while (lista_aux->prox != NULL) lista_aux = lista_aux->prox;

	lista_adj* novo_elem;
	novo_elem = (lista_adj*)malloc(sizeof(lista_adj));

	novo_elem->info = info_p;
	novo_elem->peso = peso_p;
	novo_elem->prox = NULL;

	lista_aux->prox = novo_elem;

	return lista_p;
}

void lst_adj_retira(lista_adj* lista_p) {

	if (lst_adj_vazia(lista_p) == VERDADEIRO) return; // Ao retornar para main, pedir para verificar ERRO	}
	
	lista_adj* remover_elem = lista_p;

	lista_p = lista_p->prox;

	free(remover_elem);
}

lista_adj* lst_adj_retira_objetiva(lista_adj* lista_p, int rm_info) {

	if (lst_adj_vazia(lista_p) == VERDADEIRO){
		
		return NULL;
	}

	lista_adj* rm_elem = lista_p;
	lista_adj* pre_elem = NULL;

	while ( (rm_elem->info != rm_info) && (rm_elem != NULL) ) {
		pre_elem = rm_elem;
		rm_elem = rm_elem->prox;
	}

	//	if ( rm_elem == NULL), elemento nao encontrado
	
	if ( pre_elem == NULL ) {

		lista_p = rm_elem->prox;
	}
	else {

		pre_elem->prox = rm_elem->prox;
	}

	free(rm_elem);
	return lista_p;
}
	

lista_adj* lst_adj_busca(lista_adj* lista_p, int info_alvo){
	
	lista_adj* i_ponteiro;
	
	for (i_ponteiro = lista_p; i_ponteiro != NULL; i_ponteiro = i_ponteiro->prox){
		
		if (i_ponteiro->info == info_alvo){
			
			return i_ponteiro;
		}
	}

	return NULL;
}

lista_adj* lst_adj_busca_peso(lista_adj* lista_p, int info_alvo){
	
	lista_adj* i_ponteiro;
	
	for (i_ponteiro = lista_p; i_ponteiro != NULL; i_ponteiro = i_ponteiro->prox){
		
		if (i_ponteiro->peso == info_alvo){
			
			return i_ponteiro;
		}
	}

	return NULL;
}

void lst_adj_imprime(lista_adj* lista_p){
	
	lista_adj* i_ponteiro;
	
	for (i_ponteiro = lista_p; i_ponteiro != NULL; i_ponteiro = i_ponteiro->prox){
		
		printf("\t%d\n",i_ponteiro->info);
	}

	free(i_ponteiro);
}

void lst_adj_libera(lista_adj* lista_p) {

	lista_adj* i_ponteiro = lista_p;

	while (i_ponteiro != NULL) {
		
		lista_adj* temp = i_ponteiro->prox; 
		free(i_ponteiro);
		i_ponteiro = temp;
	}
}
