#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"

#define SUCESSO 0

int main (int argc, char** argv){

	grafo* gra_tmp = grafo_cria(4);

	grafo_libera(gra_tmp);
	return SUCESSO;
}