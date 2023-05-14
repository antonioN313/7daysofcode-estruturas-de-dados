package alura.DoC.arrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class listaDeCompras {

    private List<String> item;
    private List<Integer> quantidade;

    public listaDeCompras() {
        this.item = new ArrayList<>();
        this.quantidade = new ArrayList<>();
    }
    
    public void adicionarItem(String nomeProduto, int quantidade) {
        this.item.add(nomeProduto);
        this.quantidade.add(quantidade);
    }
    
    public void removerItem(String nomeProduto) {
        int indice = this.item.indexOf(nomeProduto);
        if (indice != -1) {
            this.item.remove(indice);
            this.quantidade.remove(indice);
        }
    }
    
    public void listarItens() {
        System.out.println("Produto | Quantidade");
        for (int i = 0; i < this.item.size(); i++) {
            String nomeProduto = this.item.get(i);
            int quantidade = this.quantidade.get(i);
            System.out.println(nomeProduto + " - " + quantidade);
        }
    }
    
    
    
    public static void main(String[] args) {
        
        int quantidade,opcao;
        String nomeProduto;
        
        listaDeCompras compras = new listaDeCompras();
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("\n\n\n\tLista de Compras");
            System.out.println("\n1-Remover item");
            System.out.println("2-Listar item");
            System.out.println("3-Listar Itens");
            System.out.println("4-Sair");
            System.out.print("\n\n\tDigite a opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao)
            {
                case 1:
                    System.out.println("Nome do Produto a comprar:");
                    nomeProduto = sc.nextLine();
                    System.out.println("Quantidade para comprar:");
                    quantidade = sc.nextInt();
                    sc.nextLine();
                    compras.adicionarItem(nomeProduto, quantidade);
                    break;
                case 2:
                   System.out.println("Item que vai ser removido na lista de compras:");
                   nomeProduto = sc.nextLine();
                   compras.removerItem(nomeProduto);
                   break;
                
                case 3:
                    compras.listarItens();
                    break;
            }
            
        }while(opcao != 4);
    }
    
}
