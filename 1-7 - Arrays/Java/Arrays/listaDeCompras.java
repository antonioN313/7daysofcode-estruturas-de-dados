package alura.DoC.arrays;
import java.util.Scanner;


public class listaDeCompras{

    private String[] itens;
    private int[] quantidades;
    private int tamanho;

    public listaDeCompras(int tamanho) {
        
        this.tamanho = 0;
        this.itens = new String[tamanho];
        this.quantidades = new int[tamanho];
    }
    
    public void adicionarItem(String item,int quantidade)
    {
        this.itens[this.tamanho] = item;
        this.quantidades[this.tamanho] = quantidade;
        this.tamanho++;
    }
    
    public void removerItem(String item) {
        int indice = -1;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.itens[i].equals(item)) {
                indice = i;
                break;
            }
        }
        if (indice != -1) {
            for (int i = indice; i < this.tamanho - 1; i++) {
                this.itens[i] = this.itens[i + 1];
                this.quantidades[i] = this.quantidades[i + 1];
            }
            this.itens[this.tamanho - 1] = null;
            this.quantidades[this.tamanho - 1] = 0;
            this.tamanho--;
        }
        else
        {
            System.out.println("\n\nItem nao encontrado");
        }
    }
    
    public void listarItens() {
        if(this.tamanho == 0)
        {
            System.out.println("\n\nLista de Compras vazia");
        }
        else
        {
            
            for (int i = 0; i < this.tamanho; i++) {
                System.out.println(this.itens[i] + ": " + this.quantidades[i]);
            }
        }
    }

    
    
    public static void main(String[] args) 
    {
        String itens;
        int quantidades,tamanho,opcao;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantidade de Itens a serem comprados:");
        tamanho = sc.nextInt();
        sc.nextLine();
        
        listaDeCompras compras = new listaDeCompras(tamanho);
        
        for (int i = 0; i < tamanho; i++) 
        {
            System.out.println("Nome do Produto a comprar:");
            itens = sc.nextLine();
            System.out.println("Quantidade para comprar:");
            quantidades = sc.nextInt();
            sc.nextLine();
            compras.adicionarItem(itens, quantidades);
        }
        
        do{
            System.out.println("\n\n\n\tLista de Compras");
            System.out.println("\n1-Remover item");
            System.out.println("2-Listar item");
            System.out.println("3-Sair");
            System.out.print("\n\n\tDigite a opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao)
            {
                case 1:
                   System.out.println("Item que vai ser removido na lista de compras:");
                   itens = sc.nextLine();
                   compras.removerItem(itens);
                   break;
                
                case 2:
                   compras.listarItens();
                   break;
            }
            
        }while(opcao != 3);
        
        
    }
    
}
