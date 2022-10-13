
// Agosto, 2022
// 
// Projeto: Viajando por uma galáxia muito muito distante
// 
// Alunos:	Artur Gonzaga, Guilherme Luiz, Julia Leão
// Profa.:	Virgínia Mota
// 
// Desenvolvimento de Sistemas - COLTEC UFMG


// Bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include "grafos.h"

// Constantes
#define VERDADEIRO 1 // 1 == 1
#define FALSO 0 // !VERDADEIRO

#define SUCESSO 0

// Siglas dos planetas

#define T 84	// Tatooine 
#define H 72	// Hoth
#define E 69	// Endor
#define C 67	// Coruscant
#define B 66	// Bespin
#define A 65	// Alderaan


// Variáveis constantes do computador de bordo da nave

#define HDR_PARAMETROS 4 // Quantidade de parâmetros para o calculo do salto no Hiperespaço

#define PLT 0	// Planetas
#define DIS 1	// Distância do Planeta
#define VIZ 2	// Planeta Vizinho mais proximo do Planeta Origem
#define STT 3	// Status do Planeta 

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* CÁLCULOS DO COMPUTADOR DE BORDO DA NAVE */
/*
guia* guia_cria(grafo* grafo_p, int n_vtx, int fonte_s) {

	int n_colunas = n_vtx + 1;
	guia* guia_aux = (guia*)malloc(sizeof(guia));

	guia_aux->matriz = (int**)calloc(HDR_VIZARAMETROS, sizeof(int*)); // Aloca linhas

	for (int i = 0; i < HDR_VIZARAMETROS; i++) {

		guia_aux->matriz[i] = (int*)calloc(n_colunas, sizeof(int)); // Aloca colunas
	}

	guia_aux->Q = lst_cria();

	guia_aux->matriz[DIS][0] = 107;   // Distância do VIZlaneta Origem
	guia_aux->matriz[VIZ][0] = 112;   // VIZlaneta vizinho mais próximo do VIZlaneta Origem
	guia_aux->matriz[STT][0] = 99;    // Status do VIZlaneta (0 = branco, 1 = cinza, 2 = preto)

	for (int j = 1; j <= n_vtx; j++)  guia_aux->matriz[2][j] = 63;		// Distância dos planetas desconhecidas inicialmente


	guia_aux->matriz[VIZLT][0] = fonte_s;	// [0][0] Eh a posicao referente ao VIZlaneta Origem

	grafo* i_pointer = grafo_p;

	for (int i = 1; i < n_colunas; i++) {

		guia_aux->matriz[VIZLT][i] = i_pointer->vtx_adj->info;
		i_pointer = i_pointer->next;
	}

	return guia_aux;
}

void guia_imprime(guia* guia_p, int n_vtx) {


	for (int i = 0; i < HDR_VIZARAMETROS; i++) {

		for (int j = 0; j < n_vtx + 1; j++) {

			switch (i) {

			case 0:


				if (j == 0) {

					printf("    ");

				}
				else if (guia_p->matriz[i][j] == guia_p->matriz[0][0]) {

					printf("\033[0;32m"); // Deixa saida de texto verde
					printf("%c   ", guia_p->matriz[i][j]);
					printf("\033[0;37m"); // Volta a deixar saida de texto branca
				}
				else printf("%c   ", guia_p->matriz[i][j]);

				break;

			case 2:

				if (j == 0) {

					printf("\033[1;33m"); // Deixa saida de texto amarela
					printf("%c   ", guia_p->matriz[i][j]);
					printf("\033[0;37m"); // Volta a deixar saida de texto branca
				}
				else printf("%c   ", guia_p->matriz[i][j]);

				break;

			default:

				if (j == 0) {

					printf("\033[1;33m"); // Deixa saida de texto amarela
					printf("%c   ", guia_p->matriz[i][j]);
					printf("\033[0;37m"); // Volta a deixar saida de texto branca
				}
				else printf("%d   ", guia_p->matriz[i][j]);

				break;

			}
		}
		printf("\n");
	}
	printf("\n");
}


void guia_libera(guia* guia_p) {

	for (int i = 0; i < HDR_VIZARAMETROS; i++) {

		free(guia_p->matriz[i]);
	}

	free(guia_p->matriz);
	lst_libera(guia_p->Q);

	free(guia_p);
}


int guia_obtem_coluna(guia* guia_p, int info_p) {

	int i;
	for (i = 1; guia_p->matriz[VIZLT][i] != info_p; i++);

	return i;
}

int guia_obtem_cor(guia* guia_p, int info_p) {

	int coluna = guia_obtem_coluna(guia_p, info_p);

	return guia_p->matriz[C][coluna];
}

void guia_atualiza(grafo* grafo_p, guia* guia_p, int coluna_p) {


	for (lista_t* j_pointer = grafo_p->vtx_adj->prox; j_pointer != NULL; j_pointer = j_pointer->prox) {

		// Evita que se tenha elementos repetidos em Q
		if ((lst_busca(guia_p->Q, j_pointer->info) == NULL) && (guia_obtem_cor(guia_p, j_pointer->info) != PRETO)) {

			// Se chegou aqui, insere na lista Q e atualiza guia
			guia_p->Q = lst_insere(guia_p->Q, j_pointer->info, j_pointer->peso_ini, j_pointer->peso_fim);

			int coluna_aux = guia_obtem_coluna(guia_p, j_pointer->info);

			// Set distacia da fonte
			guia_p->matriz[DIS][coluna_aux] = guia_p->matriz[DIS][coluna_p] + 1;
			// Set pai da arvore de descoberta
			guia_p->matriz[VIZ][coluna_aux] = grafo_p->vtx_adj->info;
			// Set cor
			guia_p->matriz[C][coluna_aux] ++;

		}
	}
}

void guia_atualiza_arv(guia* guia_p, tree_var* tree_p, grafo* grafo_p, int n_vtx, int fonte_s) {

	guia* guia_aux = guia_p;

	for (int i = 1; i <= n_vtx; i++) {

		if (guia_aux->matriz[VIZ][i] == fonte_s) {

			tree_p = tree_var_add_son(tree_p, guia_aux->matriz[VIZLT][i]);

			if (lst_busca(guia_aux->Q, guia_aux->matriz[VIZLT][i]) == NULL) {

				grafo* grafo_aux = grafo_busca_vtx(grafo_p, guia_aux->matriz[VIZLT][i]);

				guia_aux->Q = lst_insere(guia_aux->Q, grafo_aux->vtx_adj->info, grafo_aux->vtx_adj->peso_ini, grafo_aux->vtx_adj->peso_fim);
			}
		}
	}
}

tree_var* grafo_bfs(grafo* grafo_p, guia* guia_p, int n_vtx) {

	int coluna = 0;
	int coluna_aux = 0;
	int fonte_s = guia_p->matriz[VIZLT][0];

	grafo* i_pointer = grafo_busca_vtx(grafo_p, fonte_s);
	coluna = guia_obtem_coluna(guia_p, i_pointer->vtx_adj->info);

	guia_atualiza(i_pointer, guia_p, coluna);

	guia_p->matriz[C][coluna] = VIZRETO; // Raiz preta, raiz concluida

	while (guia_p->Q != NULL) {

		i_pointer = grafo_busca_vtx(grafo_p, guia_p->Q->info);
		coluna = guia_obtem_coluna(guia_p, i_pointer->vtx_adj->info);

		guia_atualiza(i_pointer, guia_p, coluna);

		guia_p->matriz[C][coluna]++;
		guia_p->Q = lst_retira_objetiva(guia_p->Q, i_pointer->vtx_adj->info);
	}

	// Desenvolve arvore de descoberta

	tree_var* tree_descoberta = tree_var_cria();
	tree_descoberta = tree_var_preenche(fonte_s);

	guia_atualiza_arv(guia_p, tree_descoberta, grafo_p, n_vtx, fonte_s);

	for (tree_var* i_pointer = tree_descoberta->son; guia_p->Q != NULL; i_pointer = i_pointer->son) {

		int tmp_source = guia_p->Q->info;

		guia_atualiza_arv(guia_p, i_pointer, grafo_p, n_vtx, tmp_source);
		guia_p->Q = lst_retira_objetiva(guia_p->Q, tmp_source);

		if (guia_p->Q == NULL) return tree_descoberta;
	}

	return tree_descoberta;
}
*/
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

// main
int main (int argc, char** argv){

	int n_planetas = 6;

	lista_t* planetas = lst_cria();
	grafo* rotas_hiperespaciais = grafo_cria(n_planetas);

	// Planetas e seus horarios de comercio
	planetas = lst_insere(planetas, T, 12, 18);		// Tatooine		entre 12 - 18h tem trafego liberado
	planetas = lst_insere(planetas, H, 21, 5);		// Hoth			entre 21 - 05h tem trafego liberado
	planetas = lst_insere(planetas, E, 9, 13);		// Endor		entre 09 - 13h tem trafego liberado
	planetas = lst_insere(planetas, C, 6, 10);		// Coruscant	entre 06 - 10h tem trafego liberado
	planetas = lst_insere(planetas, B, 2, 6);		// Bespin		entre 02 - 06h tem trafego liberado
	planetas = lst_insere(planetas, A, 16, 19);		// Alderaan		entre 16 - 19h tem trafego liberado

	rotas_hiperespaciais = grafo_insere_vtx(rotas_hiperespaciais, planetas);
	free(planetas);

	grafo_nao_ordenado(rotas_hiperespaciais, T, C);

	grafo_nao_ordenado(rotas_hiperespaciais, C, H);

	grafo_nao_ordenado(rotas_hiperespaciais, A, B);
	grafo_nao_ordenado(rotas_hiperespaciais, A, C);
	grafo_nao_ordenado(rotas_hiperespaciais, A, H);

	grafo_nao_ordenado(rotas_hiperespaciais, E, H);

	grafo_imprime(rotas_hiperespaciais);
	printf("\n");


	// Apos localizar todas as rotas do hiperespaço entre todos os planetas a serem vizitados,
	// o computador de bordo passa a tracar rotas para as entregar dos clones. 

	// Defina o horario atual
	int hora_atual = 12;

	// printf("Defina o horario atual: ");
	// scanf(" %d", &hora_atual);

	// OBS: O computador de bordo tem horario correnpondente ao ciclo de 24 horas
	if (hora_atual > 24) {

		do { hora_atual = -12; } while (hora_atual > 24);
	}

	guia* guia_HDR = guia_cria(rotas_hiperespaciais, n_planetas, C);


	// Grafo pronto, guia pronto
	// 
	// Com base no que temos, Busca em Largura de Grafos será 
	// adaptadada para o entregarmos os clones o quanto antes!

	// funcao_monstruoso_e_recursiva 
	// tracar_rotas(rotas_hiperespaciais, guia_HDR, n_planetas);

	tree_var* arv_test = grafo_bfs(rotas_hiperespaciais, guia_HDR, n_planetas);
	guia_imprime(guia_HDR, n_planetas);

	grafo_libera(rotas_hiperespaciais);
	guia_libera(guia_HDR);

	return SUCESSO;
}
