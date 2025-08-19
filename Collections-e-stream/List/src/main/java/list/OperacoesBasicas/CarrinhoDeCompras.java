package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras(){
        this.itens = new ArrayList<>();
    }

    public void AdicionarItem(String nome, double preco, int quantidade){
        this.itens.add(new Item(nome,preco,quantidade));
        System.out.println("Item adicionado");
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for(Item item : this.itens){
            if (item.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(item);
            }
        }
        this.itens.removeAll(itensParaRemover);

    }

    public double calcularValorTotal(){
        double total = 0;
        for(Item item : this.itens){
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens(){
        System.out.println(this.itens.toString());
    }
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.AdicionarItem("Carro", 200.2, 1);
        carrinho.AdicionarItem("Agua", 2.39, 2);
        carrinho.AdicionarItem("Bolo Sodie", 200, 3);
        carrinho.AdicionarItem("Bolo Sodie", 200, 3);
        double total = carrinho.calcularValorTotal();
        System.out.println("Total: " + total);
        carrinho.exibirItens();
        carrinho.removerItem("Bolo Sodie");
        carrinho.exibirItens();

    }
}
