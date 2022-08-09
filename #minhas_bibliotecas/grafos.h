// Agosto, 2022
// grafos.h - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

// Bibliotecas
#include <stdint.h>
#include "listas.h"


typedef uint8_t bool;

typedef struct grafo_s {

	lista_t* vtx_adj;
	struct grafo_s* next;
} grafo;


grafo* grafo_cria(int n_vtx); 

grafo* grafo_insere_vtx(grafo* grafo_p, lista_t* valores); 

grafo* grafo_busca_vtx(grafo* grafo_p, int vtx_p); 

lista_t* grafo_busca_no_vtx(grafo* grafo_p, int vtx_p, int info_p);

grafo* grafo_insere_adj(grafo* grafo_p, int vtx_p, int info_p); 

int grafo_obter_grau(grafo* grafo_p, int vtx_p);

void grafo_nao_ordenado(grafo* grafo_p, int vtx_a, int vtx_b);

void grafo_imprime(grafo* grafo_p);

void grafo_libera (grafo* grafo_p); 