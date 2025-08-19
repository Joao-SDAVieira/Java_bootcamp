package main.java.set.Pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean foiConcluida = false;

    public Tarefa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public boolean getFoiConcluida(){
        return this.foiConcluida;
    }

    public void setFoiConcluida(){
        this.foiConcluida = true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDescricao());
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", foiConcluida=" + foiConcluida +
                '}';
    }
}
