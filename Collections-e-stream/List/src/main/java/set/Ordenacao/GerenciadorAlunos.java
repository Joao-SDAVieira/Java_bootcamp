package main.java.set.Ordenacao;

import java.lang.reflect.GenericArrayType;
import java.util.*;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos(){
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunosSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(Long matricula){
        for(Aluno aluno: alunosSet){
            if(Objects.equals(aluno.matricula(), matricula)){
                alunosSet.remove(aluno);
                System.out.println("Aluno removido");
                return;
            }
        }
        System.out.println("Aluno não encontrado");
    }
    public void exibirAlunosPorNome(){
        System.out.println(new TreeSet<>(alunosSet));
    }
    public void exibirAlunosPorNota(){
        List<Aluno> alunosPorNome = new ArrayList<>(alunosSet);
        alunosPorNome.sort(new ComparableAlunosPorNota());
        System.out.println(alunosPorNome);
    }
    public void exibirAlunos(){
        System.out.println(alunosSet.toString());
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        gerenciadorAlunos.adicionarAluno("Victor2", 2L, 2.20);
        gerenciadorAlunos.adicionarAluno("João2", 1L, 7.20);
        gerenciadorAlunos.adicionarAluno("João3", 5L, 8.20);
        gerenciadorAlunos.adicionarAluno("Victor", 3L, 8.20);
        gerenciadorAlunos.adicionarAluno("João", 2L, 2.20);

        gerenciadorAlunos.removerAluno(1L);

        gerenciadorAlunos.exibirAlunosPorNome();
        System.out.println("========");
        gerenciadorAlunos.exibirAlunosPorNota(); //apenas com 2 alunos

        System.out.println("=======");
        gerenciadorAlunos.exibirAlunos();
    }

}
