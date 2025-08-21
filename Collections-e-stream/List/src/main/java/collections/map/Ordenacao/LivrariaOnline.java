package main.java.collections.map.Ordenacao;

import java.util.Map;
import java.util.TreeMap;

public class LivrariaOnline {
    private Map<String, Livro> livrariaMap;

    public LivrariaOnline(){
        this.livrariaMap = new TreeMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, int preco){
        this.livrariaMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
//        livrariaMap.
    }
}
