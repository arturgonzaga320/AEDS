// Junho, 2022
// filas.h - Artur Gonzaga
// Desenvolvimento de Sistemas - COLTEC UFMG

typedef uint8_t bool;

typedef struct lst_s{
	int info;
	struct lst_s* prox;
}lista_t;

typedef struct fila_s {
	lista_t* inicio;
	lista_t* fim;
}fila_lst;

//Implementacao com Listas Encadeadas

fila_lst* fila_lst_cria();
bool fila_lst_vazia(fila_lst* fila_p);

void fila_lst_insere(fila_lst* fila_p,int info_param);
int fila_lst_retira(fila_lst* fila_p);

void fila_lst_inverte(fila_lst* fila_p);
lista_t* fila_lst_busca (fila_lst* fila_p, int info_alvo);

void fila_lst_imprime(fila_lst* fila_p);

void fila_lst_libera(fila_lst* fila_p);