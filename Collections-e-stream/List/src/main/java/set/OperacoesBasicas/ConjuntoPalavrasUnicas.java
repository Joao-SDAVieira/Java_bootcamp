package main.java.set.OperacoesBasicas;

import java.util.LinkedHashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasSet;

    public ConjuntoPalavrasUnicas(){
        this.palavrasSet = new LinkedHashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasSet.add(palavra);
    }

    public void removerPalavra(String palavraParaRemover){
        for(String palavra: palavrasSet){
            if(palavra == palavraParaRemover){
                palavrasSet.remove(palavra);
                System.out.println("Palavra removida");
                return;
            }
        }
        System.out.println("Palavra não encontrada");
    }
    public boolean verificarPalavra(String palavra){
        return palavrasSet.contains(palavra);
    }

    public Set<String> exibirPalavrasUnicas(){
        Set<String> palavrasUnicas = new LinkedHashSet<>();
        return palavrasSet;
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();
        conjuntoPalavras.adicionarPalavra("Palavra1");
        conjuntoPalavras.adicionarPalavra("Palavra2");
        conjuntoPalavras.adicionarPalavra("Palavra1");
        conjuntoPalavras.adicionarPalavra("Palavra3");
        conjuntoPalavras.adicionarPalavra("Palavra0");
        conjuntoPalavras.adicionarPalavra("Palavra6");
        conjuntoPalavras.adicionarPalavra("Palavra5");

        System.out.println(conjuntoPalavras.exibirPalavrasUnicas());

        System.out.println(conjuntoPalavras.verificarPalavra("Palavra3")); //true
        conjuntoPalavras.removerPalavra("Palavra3");
        System.out.println(conjuntoPalavras.verificarPalavra("Palavra3")); //false
        conjuntoPalavras.removerPalavra("Palavra200");


    }
}
