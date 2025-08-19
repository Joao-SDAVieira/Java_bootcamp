package main.java.set.Ordenacao;

import java.util.Comparator;

public record Aluno(String nome, Long matricula, double media) implements Comparable<Aluno> {
    @Override
    public int compareTo(Aluno aluno){
        return this.nome.compareTo(aluno.nome());
    }
}

class ComparableAlunosPorNota implements Comparator<Aluno> {
    @Override
    public int compare(Aluno aluno1, Aluno aluno2){
        return Double.compare(aluno1.media(), aluno2.media());
    }
}
