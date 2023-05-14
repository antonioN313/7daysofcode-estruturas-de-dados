/*Implementacao de uma Lista linear Contigua com Constante*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ITEMS 100

typedef struct {
    char nome[50];
    int quantidade;
} Item;

typedef struct {
    Item itens[MAX_ITEMS];
    int num_itens;
} ListaDeCompras;

void nova_lista(ListaDeCompras *compras)
{
    compras->num_itens = 0;
}
/* 
Outro Metodo de Criar uma Nova Lista
ListaDeCompras nova_lista() {
    ListaDeCompras lista;
    lista.num_itens = 0;
    return lista;
}
*/


void adicionarItem(ListaDeCompras* lista, char* nome, int quantidade) {
    if (lista->num_itens >= MAX_ITEMS) {
        printf("lista cheia!\n");
        return;
    }
    Item item;
    strcpy(item.nome, nome);
    item.quantidade = quantidade;
    lista->itens[lista->num_itens++] = item;
}


void removerItem(ListaDeCompras* lista, char* nome) {
    int i, j;
    for (i = 0; i < lista->num_itens; i++) {
        if (strcmp(lista->itens[i].nome, nome) == 0) {
            for (j = i+1; j < lista->num_itens; j++) {
                lista->itens[j-1] = lista->itens[j];
            }
            lista->num_itens--;
            break;
        }
    }
}


void listarItens(ListaDeCompras *lista) {
    int i;
    for (i = 0; i < lista->num_itens; i++) {
        printf("%s - %d\n", lista->itens[i].nome, lista->itens[i].quantidade);
    }
}

int main() {
    
    /* Outro metodo de Iniciar uma Lista
    ListaDeCompras lista = nova_lista();*/

    char produto[50];
    int quantidade;
    ListaDeCompras compras;

    nova_lista(&compras);
    

    adicionarItem(&compras, "Maca", 5);
    adicionarItem(&compras, "Leite", 2);
    adicionarItem(&compras, "Pao", 1);
    adicionarItem(&compras, "Cupcake", 5);
    adicionarItem(&compras, "Macarrao", 2);
    adicionarItem(&compras, "Cartela de Ovos", 1);

    listarItens(&compras);

    removerItem(&compras, "Leite");
    removerItem(&compras, "Cupcake");
    adicionarItem(&compras, "Maca", 5);

    listarItens(&compras);

    free(&compras);

    return 0;
}
