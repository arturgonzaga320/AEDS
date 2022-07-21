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


grafo* grafo_cria(grafo* gra_p, int n_vtx);

/*
bool grafo_vazio (grafo* gra_p);
*/
grafo* grafo_insere (grafo* gra_p, int vtx_p, int info_p);

grafo* grafo_insere_adj(grafo* gra_p, int vtx_p, int info_p);

void grafo_libera (grafo* gra_p);