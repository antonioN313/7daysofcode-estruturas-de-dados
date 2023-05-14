class ListaDeCompras {
    constructor() {
      this.itens = [];
      this.quantidades = [];
    }
  
    adicionar_item(nome, quantidade) {
      this.itens.push(nome);
      this.quantidades.push(quantidade);
    }
  
    remover_item(nome) {
      const indice = this.itens.indexOf(nome);
      if (indice !== -1) {
        this.itens.splice(indice, 1);
        this.quantidades.splice(indice, 1);
      }
    }
  
    listar_itens() {
      for (let i = 0; i < this.itens.length; i++) {
        console.log(`${this.itens[i]}: ${this.quantidades[i]}`);
      }
    }
}

const compras = new ListaDeCompras();

compras.adicionar_item("Arroz",4);
compras.adicionar_item("Farinha de Trigo",6);
compras.adicionar_item("Fermento",2);
compras.adicionar_item("Cartela Ovos (12 unid.)",4);

compras.listar_itens();

compras.remover_item("Arroz");
compras.remover_item("Farinha de Trigo");
compras.remover_item("Fermento");
compras.remover_item("Cartela Ovos (12 unid.)");

compras.listar_itens();