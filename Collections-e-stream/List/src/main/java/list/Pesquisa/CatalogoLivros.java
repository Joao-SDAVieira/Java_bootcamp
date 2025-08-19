package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private final List<Livro> livroList;

    public CatalogoLivros(){
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, int anoPulicacao, String autor){
        this.livroList.add(new Livro(titulo, anoPulicacao, autor));
        System.out.println("Livro adicionado");
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!this.livroList.isEmpty()){
            for(Livro livro: this.livroList){
                if(livro.getAutor().equalsIgnoreCase(autor)){
                     livrosPorAutor.add(livro);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPPorIntervaloAnos = new ArrayList<>();
        if (!this.livroList.isEmpty()) {
            for (Livro livro : this.livroList) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                    livrosPPorIntervaloAnos.add(livro);
                }
            }

        }
        return livrosPPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if (!this.livroList.isEmpty()){
            for(Livro livro: livroList){
                if(livro.getLivro().equalsIgnoreCase(titulo)){
                    livroPorTitulo = livro;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", 2020, "Autor 1");
        catalogoLivros.adicionarLivro("Livro 1", 2021, "Autor 2");
        catalogoLivros.adicionarLivro("Livro 2", 2022, "Autor 2");
        catalogoLivros.adicionarLivro("Livro 3", 2023, "Autor 3");
        catalogoLivros.adicionarLivro("Livro 4", 1994, "Autor 4");

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1990, 2020));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
    }
}
