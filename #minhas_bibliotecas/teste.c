#include <stdio.h>
#include <stdlib.h>

#include "grafos.c"
#define SUCESSO 0

int main (int argc, char** argv){

	grafo* gra_t;

	gra_t = grafo_cria(gra_t, 2);

	grafo_libera(gra_t);
	return SUCESSO;
}
