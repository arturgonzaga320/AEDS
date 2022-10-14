#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include "filas_char.h"

#define ERRO "  Erro  "
#define FALSO 1
#define	SUCESSO 0
#define VERDADEIRO 0
#define TAMANHO_MAX (8+1)

void add_veiculo(fila_lst* fila_do_estacionamento) {
	
	char* placa = (char*) malloc( sizeof(char) * TAMANHO_MAX );

	printf("\tPlaca do veiculo: ");
	fgets(placa, TAMANHO_MAX, stdin);

	if (fila_lst_busca(fila_do_estacionamento, placa) != NULL) {
	
		printf("\n\t!! CUIDADO: Placas clonadas");
		printf("\n\t   Registre um Boletim de Ocorrencia em alguma delegacia policial\n");
	}

	fila_lst_insere(fila_do_estacionamento, placa);
	free(placa);
}

void rm_veiculo(fila_lst* fila_do_estacionamento, int n_veiculos) {

	printf("\n\tFila atual do estacionamento:\n\t\t\t--------\n");
	fila_lst_imprime(fila_do_estacionamento);
	printf("\t\t\t--------\n");

	char* remover_placa = (char*)malloc(sizeof(char) * TAMANHO_MAX);

	printf("\n\tPlaca do veiculo: ");
	fgets(remover_placa, TAMANHO_MAX, stdin);

	if (fila_lst_busca(fila_do_estacionamento, remover_placa) == NULL) {

		printf("\tVeiculo nao encontrada!\n");
		return;
	}

	lista_t* i_ponteiro = fila_do_estacionamento->inicio;

	while (i_ponteiro != fila_lst_busca(fila_do_estacionamento, remover_placa) ) {

		char* tmp = (char*)malloc(sizeof(char) * TAMANHO_MAX);
		tmp = fila_lst_retira(fila_do_estacionamento);
		fila_lst_insere(fila_do_estacionamento, tmp);
		i_ponteiro = fila_do_estacionamento->inicio;
	}

	char* tmp = (char*)malloc(sizeof(char) * TAMANHO_MAX);
	tmp = fila_lst_retira(fila_do_estacionamento);
	free(tmp);

	n_veiculos--;

	if (n_veiculos < 1) {
		printf("\tFila do estacionamento vazia!\n");
	}
	else {
		printf("\n\tFila do estacionamento atualizada:\n\t\t\t--------\n");
		fila_lst_imprime(fila_do_estacionamento);
		printf("\t\t\t--------\n");
	}

}


int main (int argc, char** argv) {
	
	int opcao,qtd_veiculos=0;
	fila_lst* main_fila;
	main_fila = (fila_lst*)malloc(sizeof(fila_lst));
	main_fila = fila_lst_cria();

	printf("\tESTACIONAMENTO com filas\n ");
	printf("\n\tOpcoes:\n\t0 - Sair\n\t1 - Adicionar veiculo no estacionamento\n\t2 - Remover veiculo do estacionamento\n\n");
	printf("\tObservacao:\n\tFormato de entrada da placa = \"AAA-1111\"\n\n");

	for (;;) {

		printf("\t> ");
		scanf("%d", &opcao);
		getchar();

		switch (opcao) {
		case 0:
			return SUCESSO;
			break;
		case 1:
			add_veiculo(main_fila);
			qtd_veiculos++;
			break;
		case 2:
			if (qtd_veiculos == 0) {
				printf("\tFila do estacionamento vazia!\n");
			}
			else {
				rm_veiculo(main_fila, qtd_veiculos);
				qtd_veiculos--;
			}
			break;
		default:
			printf("\tOpcao invalida\n");
			break;
		}

		printf("\t-------------------------------------------------------------------\n");
	}
	
	return SUCESSO;
}
