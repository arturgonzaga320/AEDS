
// Atividade de Grafos ( 03 )
// Artur Gonzaga da Silva Gomes, 203
// Profa. Virgínia Mota

// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"


// Constantes
#define SUCESSO 0
#define N_SERVIDORES 10

// Funções
void imprime_conexoes(lista_t* servidor) {

	int n_maquinas = 0;

	printf("\tConectado aos servidores: ");

	while (servidor != NULL) {

		if (servidor->info > 10) printf("%c ", servidor->info);
		else n_maquinas++;
		
		if (servidor->prox == NULL) {
			
			printf("\n\tConectado com %d m%cquina(s).", n_maquinas, 160);
		}

		servidor = servidor->prox;
	}
}

// main
int main(int argc, char** argv) {

	grafo* i_pointer;
	lista_t* main_vtxs = lst_cria();
	grafo* servers = grafo_cria(N_SERVIDORES);

	// Servidores de 'a' a 'j' 
	for (int i = 106; i > 96; i--) { 
		main_vtxs = lst_insere(main_vtxs, i); 
	}

	// Insere valores nos vertices e libera a lista que os armazenava
	servers = grafo_insere_vtx(servers, main_vtxs);
	free(main_vtxs);

	for (int i = 97; i < 105; i++) { // Erro nos servers 'i' e 'j', para corrigir: i < 107

		for (int j = i + 1; j < 107; j++) {
		
			grafo_nao_ordenado(servers, i, j);
		}
	}


	// Estabelece a conexão de cada servidor com suas 8 máquinas

	for (int i = 98; i < 107; i++) { // Erro no server 'a', para corrigir: int i = 97

		for (int j = 4; j < 9; j++) { // Erro todos os servers, para corrigir: int j = 1

			// Servidor 'a' monitora as máquinas '1', 'b' monitora as '2', etc
			grafo_insere_adj(servers, i, ( i - 96) );
		}
	}

	// No final do processo, cada servidor deve ter 
	// grau 17 ( conexão com os outros 9 servidores e com as 8 máquinas )

	for (i_pointer = servers; i_pointer != NULL; i_pointer = i_pointer->next) {

		if (grafo_obter_grau(i_pointer, i_pointer->vtx_adj->info) != 17) {

			printf("!! Servidor %c n%co apresenta conectividade adequada\n", i_pointer->vtx_adj->info, 198);
		}
	}

	// Imprime grafo

	printf("\n\nConectividade entre os servidores:\n\n");
	grafo_imprime(servers);


	printf("\n\nStatus de cada servidor:\n\n");

	for (i_pointer = servers; i_pointer != NULL; i_pointer = i_pointer->next) {

		printf("\t>Servidor %c\n", i_pointer->vtx_adj->info);
		imprime_conexoes(i_pointer->vtx_adj->prox);
		printf("\n\n");
	}

	grafo_libera(servers);

	return SUCESSO;
}
