package main.java.collections.map.Ordenacao;

public record Livro(String titulo, String autor, int preco) {
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String autor() {
        return autor;
    }

    @Override
    public int preco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }
}
