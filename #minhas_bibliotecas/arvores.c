#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include "arvores.h"

#define VERDADE (1 == 1)
#define FALSO !VERDADEIRO

typedef uint8_t bool;

typedef struct arv_s{

	int info;
	
	struct arv_s* son_dir;
	struct arv_s* son_esq;

} Arv_t;

// pré ordem: raiz, esq, dir;
// ordem simetrica: esq, raiz, dir;
// pós ordem: esq, dir, raiz;

bool arv_vazia (Arv* arv_p){

	if (arv_p == NULL) {
	
		return VERDADEIRO;
	}

	else return FALSO;
}

void arv_imprime_preOrdem (Arv_t* arv_p){

	// pré ordem: raiz, esq, dir;
	
	if (arv_vazia(arv_p) == FALSO){
		
		printf ("%d", arv_p->info);
		arv_imprime ( arv_p->son_esq );
		arv_imprime ( arv_p->son_dir );	
		
	}
}

void arv_imprime_simOrdem (Arv_t* arv_p){

	// ordem simetrica: esq, raiz, dir;
	
	if (arv_vazia(arv_cp) == FALSO){

		arv_imprime ( arv_p->son_esq );
		printf ("%d", arv_p->info);
		arv_imprime ( arv_p->son_dir );
	}
}

void arv_imprime_posOrdem (Arv_t* arv_p){
	
	// pós ordem: esq, dir, raiz;

	if (arv_vazia(arv_p) == FALSO){
		
		arv_imprime ( arv_p->son_esq );
		arv_imprime ( arv_p->son_dir );	
		
		printf ("%d", arv_p->info);
	}
}

Arv_t* libera (Arv_t* arv_p){

	// pós ordem - obrigatoriamente -

	if (arv_vazia(arv_p) == FALSO){
		
		arv_libera ( arv_p->son_esq );
		arv_libera ( arv_p->son_dir );	

		free (arv_p);
	}

	return NULL;
}
