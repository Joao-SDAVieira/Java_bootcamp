package main.java.collections.map.Ordenacao;

public class Evento {
    private String nome;
    private String atracao;

    public Evento(String nome, String atracao){
        this.nome = nome;
        this.atracao = atracao;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", atracao='" + atracao + '\'' +
                '}';
    }

    public String getAtracao() {
        return atracao;
    }
}
