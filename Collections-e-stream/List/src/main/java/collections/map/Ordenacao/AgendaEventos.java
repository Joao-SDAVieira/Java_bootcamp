package main.java.collections.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos(){
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventoMap.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
         LocalDate dataAtual = LocalDate.now();
         LocalDate proximaData = null;
         Evento proximoEvento = null;
         Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
         for(Map.Entry<LocalDate, Evento> entry: eventosTreeMap.entrySet()){
             proximaData = entry.getKey();
             if (proximaData.isEqual(dataAtual) || proximaData.isAfter(dataAtual)){
                 proximoEvento = entry.getValue();
                 System.out.println("O próximo Evento: "+ proximoEvento+ " acontecerá na data "+proximaData);
                 break;
             }
         }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atracao");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Atracao 2");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Evento 3", "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(2026, 8, 20), "Evento 4", "Atracao 4");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();


    }
}
