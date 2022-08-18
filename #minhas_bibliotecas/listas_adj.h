// Junho, 2022
// listas.h - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

#include <stdint.h>

typedef uint8_t bool;

typedef struct lst_adj_s{

	int info;
	int peso;
	struct lst_adj_s* prox;
} lista_adj;

lista_adj* lst_adj_cria();
bool lst_adj_vazia(lista_adj* lista_p);

lista_adj* lst_adj_insere(lista_adj* lista_p,int info_param);
lista_adj* lst_adj_push(lista_adj* lista_p, int info_param); // Insere como se fosse uma pilha

void lst_adj_retira(lista_adj* lista_p);
lista_adj* lst_adj_retira_objetiva (lista_adj* lista_p, int rm_info);

lista_adj* lst_adj_busca (lista_adj* lista_p, int info_alvo);
lista_adj* lst_adj_busca (lista_adj* lista_p, int info_alvo);

void lst_imprime(lista_adj* lista_p);

void lst_libera(lista_adj* lista_p);
