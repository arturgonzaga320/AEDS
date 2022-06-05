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

	char* placa_removida = (char*) malloc (sizeof(char) * TAMANHO_MAX );
	placa_removida = fila_lst_retira(fila_do_estacionamento);

	if (placa_removida == ERRO) {

		printf("\tEstado do estacionamento: Vazio!\n");
		return;
	}

	fila_lst_inverte(fila_do_estacionamento);

	printf("\tVeiculo que saiu: %s\n", placa_removida);
	
	n_veiculos--;

	if (n_veiculos < 1) {
		printf("\tEstado do estacionamento: Vazio!\n");
	}
	else {
		printf("\tEstado do estacionamento: Ocupado por %02d veiculo(s)\n", n_veiculos);
		printf("\n\tFila do estacionamento, ordem de saida:\n\t\t\t--------\n");
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
			qtd_veiculos++;
			add_veiculo(main_fila);
			break;
		case 2:
			if (qtd_veiculos == 0) {
				printf("\tEstacionamento vazio!\n");
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
