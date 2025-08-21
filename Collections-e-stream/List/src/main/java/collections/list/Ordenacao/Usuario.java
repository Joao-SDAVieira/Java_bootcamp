package main.java.collections.list.Ordenacao;

import java.util.Comparator;

public class Usuario implements Comparable<Usuario>{
    private String nome;
    private int idade;
    private double altura;

    public Usuario(double altura, int idade, String nome) {
        this.altura = altura;
        this.idade = idade;
        this.nome = nome;
    }

    @Override
    public int compareTo(Usuario usuario){
        return Integer.compare(idade, usuario.getIdade());
    }

    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }

}

class ComparatorPorAltura implements Comparator<Usuario> {
    @Override
    public int compare(Usuario usuario1, Usuario usuario2){
        return Double.compare(usuario1.getAltura(), usuario2.getAltura());
    }
}
