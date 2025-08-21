package main.java.collections.set.Pesquisa;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ConjuntoTarefas {
    private Set<Tarefa> tarefasSet;

    public ConjuntoTarefas(){
        this.tarefasSet = new LinkedHashSet<>();
    }

    public void adicionarTarefa(String descricao){
        this.tarefasSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        for(Tarefa tarefa: this.tarefasSet){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                this.tarefasSet.remove(tarefa);
                System.out.println("Tarefa removida");
                return;
            }
        }
        System.out.println("Tarefa não encontrada");
    }
    public void exibirTarefas(){
        System.out.println(this.tarefasSet.toString());
    }

    public int contarTarefas(){
        return this.tarefasSet.size();
    }

    public List<String> obterTarefasConcluidas(){
        List<String> tarefasConcluidas = new ArrayList<>();
        for(Tarefa tarefa: this.tarefasSet){
            if(tarefa.getFoiConcluida()){
                tarefasConcluidas.add(tarefa.toString());
            }
        }
        return tarefasConcluidas;
    }
    public List<String> obterTarefasPendentes(){
        List<String> tarefasPendentes = new ArrayList<>();
        for(Tarefa tarefa: this.tarefasSet){
            if(!tarefa.getFoiConcluida()){
                tarefasPendentes.add(tarefa.toString());
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa tarefa: this.tarefasSet){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefa.setFoiConcluida();
            }
            System.out.println("Marcada como concluída");
            return;
        }
        System.out.println("Não encontrada");
    }
    public void limparListaTarefas(){
        this.tarefasSet.clear();
    }

    public static void main(String[] args) {
        ConjuntoTarefas conjuntoTarefas = new ConjuntoTarefas();
        conjuntoTarefas.adicionarTarefa("Comprar pao");
        conjuntoTarefas.adicionarTarefa("Estudar ingles");
        conjuntoTarefas.adicionarTarefa("Estudar java");
        conjuntoTarefas.adicionarTarefa("Estudar fastapi");
        conjuntoTarefas.adicionarTarefa("Desenvolver projetos");
        conjuntoTarefas.adicionarTarefa("Estudar java");

        conjuntoTarefas.exibirTarefas();
        conjuntoTarefas.marcarTarefaConcluida("Comprar pao");
        conjuntoTarefas.removerTarefa("Desenvolver projetos");
        System.out.println(conjuntoTarefas.obterTarefasPendentes());
        System.out.println(conjuntoTarefas.obterTarefasConcluidas());

        conjuntoTarefas.exibirTarefas();

        System.out.println(conjuntoTarefas.contarTarefas());
        conjuntoTarefas.limparListaTarefas();
        System.out.println(conjuntoTarefas.contarTarefas());


    }

}
