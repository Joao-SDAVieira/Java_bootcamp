package main.java.collections.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;
    private String ola;
    public EstoqueProdutos(){
        this.estoqueProdutosMap = new HashMap<>();
    }
    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            for(Produto produto: estoqueProdutosMap.values()){
                valorTotalEstoque += produto.getQuantidade() * produto.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for(Produto produto: estoqueProdutosMap.values()){
            if(produto.getPreco() > maiorPreco){
                produtoMaisCaro = produto;
                maiorPreco = produto.getPreco();
            }
        }
        return produtoMaisCaro;
    }


    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.adicionarProduto(4L, "Produto E", 2, 25.0);
        estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
        estoque.adicionarProduto(2L, "Produto B", 5, 10.0);
        estoque.adicionarProduto(8L, "Produto D", 2, 20.0);
        estoque.adicionarProduto(3L, "Produto C", 2, 15.0);


        System.out.println(estoque.calcularValorTotalEstoque());

        System.out.println("\n"+estoque.obterProdutoMaisCaro());
        estoque.exibirProdutos();


    }
}

