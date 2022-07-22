// Junho, 2022
// listas.c - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

#include <stdint.h>
#include "listas.h"

typedef uint8_t bool;

typedef struct grafo_s {

	lista_t* vtx_adj;
	struct grafo_s* next;
} grafo;


grafo* grafo_cria(int n_vtx); // OK

grafo* grafo_insere_vtx(grafo* grafo_p, lista_t* valores); // OK

grafo* grafo_busca(grafo* grafo_p, int info_p); // OK

grafo* grafo_insere_adj(grafo* gra_p, int vtx_p, int info_p); // OK

void grafo_libera (grafo* gra_p); // OK