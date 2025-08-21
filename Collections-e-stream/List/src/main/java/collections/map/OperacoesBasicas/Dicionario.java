package main.java.collections.map.OperacoesBasicas;

import java.util.Map;
import java.util.TreeMap;

public class Dicionario {
    private Map<String, String> palavraSet;

    public Dicionario(){
        this.palavraSet = new TreeMap<>();
    }
    public void adicionarPalavra(String palavra, String definicao){
        palavraSet.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(!palavraSet.containsKey(palavra)){return;}
        palavraSet.remove(palavra);
    }

    public void exibirPalavras(){
        System.out.println(palavraSet);
    }
    public void pesquisarPalavra(String palavra){
        System.out.println(palavraSet.get(palavra));
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Cultura", "Conjunto de expressões, costumes, valores");
        dicionario.adicionarPalavra("Ética", "conjunto de princípios e valores morais que orientam o comportamento humano, tanto em nível individual quanto social");

        dicionario.exibirPalavras();
        dicionario.pesquisarPalavra("Cultura");
        dicionario.removerPalavra("Cultura");
        dicionario.exibirPalavras();
    }
}
