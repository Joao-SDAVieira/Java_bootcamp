package main.java.collections.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos(){
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome= null;
        if(!agendaContatoMap.isEmpty()){
        numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.adicionarContato("João", 119768897);
        agendaContatos.adicionarContato("João", 1154554);
        agendaContatos.adicionarContato("Victor", 115487);
        agendaContatos.adicionarContato("João Victor", 1154444);

        agendaContatos.removerContato("Victor");
        System.out.println(agendaContatos.pesquisarPorNome("João Victor"));
        agendaContatos.exibirContatos();
    }
}
