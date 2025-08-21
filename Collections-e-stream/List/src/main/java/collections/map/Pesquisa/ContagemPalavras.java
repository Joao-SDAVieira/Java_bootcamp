package main.java.collections.map.Pesquisa;

import java.util.Map;
import java.util.TreeMap;

public class ContagemPalavras {
    private Map<String, Integer> contagemMap;

    public ContagemPalavras(){
        this.contagemMap = new TreeMap<>();
    }

    public void adicionarPalavra(String palavra, int qtdVezes){
        contagemMap.put(palavra, qtdVezes);
    }
    public void removerPalavra(String palavra){
        contagemMap.remove(palavra);
    }
    public void exibirContagemPalavras(){
        System.out.println(contagemMap);
    }
    public void encontrarPalavraMaisFrequente(){
        String palavraMaisFrequente = "";
        int quantidadeVezes = Integer.MIN_VALUE;
        for(String palavra: contagemMap.keySet()){
            if (contagemMap.get(palavra) > quantidadeVezes){
                palavraMaisFrequente = palavra;
                quantidadeVezes = contagemMap.get(palavra);
            }
        }
        System.out.println("Palavra Mais frequente: " + palavraMaisFrequente + " Apareceu: "+ quantidadeVezes+" vezes");
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.adicionarPalavra("Ola", 20);
        contagemPalavras.adicionarPalavra("Tudo bem?", 15);
        contagemPalavras.adicionarPalavra("Tipo", 30);
        contagemPalavras.adicionarPalavra("Salve", 25);

        contagemPalavras.exibirContagemPalavras();
        contagemPalavras.encontrarPalavraMaisFrequente();
        contagemPalavras.removerPalavra("Tipo");
        contagemPalavras.encontrarPalavraMaisFrequente();

    }
}
