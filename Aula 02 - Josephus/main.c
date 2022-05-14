// Aula 02: Exercicios [ Josephus ]
// Artur Gonzaga, 203 - Prof. Virginia
// #ELMAIAFOREVER

//Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "listas.h"

#define SUCESSO 0

int ache_Josephus (int n_pessoas,int passos){
	
	int eliminados;
	int grupo_de_risco;
	int executar, executado;
	int passos_ex = 0;

	Lista* rebels;
	Lista* rebels_p;
	
	rebels = lst_cria();

	// Enumerando posicoes
	for (int i = n_pessoas ; i > 0 ; i--) {
		rebels = lst_insere(rebels,i);
	}

	rebels = lcirc_transforma(rebels);
	rebels_p = rebels; //percorredor

	while (n_pessoas != 1) {
		
		while ( int i = i;i<passos;i++){{
			rebels_p = rebels_p-prox;
		}
		executado = rebels_p->info;

		rebels_p = rebels;

		while(rebels_p->info != (rebels_p->prox)->info){
			
			rebels_p = rebels->prox;
		}

		rebels->prox = NULL;
		rebels_p = lst_retira(rebels_p,executado);
		printf("\nRebelde %d executado", executado);

		n_pessoas --;
	}

	return  rebels->info;
}

int main (int argc,char** argv) {
	
	int n_pessoas;
	int passos;

	printf("\n\t> O PROBLEMA JOSEPHUS <\n\n");

	printf("\t> Digite a quatidade de pessoas: ");
	scanf(" %d", &n_pessoas);

	printf("\t> Digite a quatidade de passos: ");
	scanf(" %d", &passos);

	printf("\t> Josephus estara segura na posicao %02d", ache_Josephus(n_pessoas,passos)); 	

	return SUCESSO;
}
