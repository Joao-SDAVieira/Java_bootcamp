package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Pedro", "Leandro", "Julia", "Ana", "Carlos",};

        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }
            else {
                System.out.println("Contato realizado com sucesso!");
            }
        }while(continuarTentando && tentativasRealizadas<=3);
        if(atendeu)
            {
                System.out.printf("Conseguimos contato com %s na %s° tentativa\n", candidato, tentativasRealizadas);
            }
        else{
            System.out.printf("Não conseguimos contato com %s número máximo de tentativas excedidas\n", candidato);
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    public static void imprimirSelecionados(){
        String [] candidatos = {"Pedro", "Leandro", "Julia", "Ana", "Carlos",};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice=0; indice < candidatos.length; indice++){
            System.out.printf("O candidato de nº %s é %s\n", indice+1, candidatos[indice]);
        }
        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"Pedro", "Leandro", "Julia", "Ana", "Carlos", "Maria", "Andressa", "Camargo", "Tony", "Stark"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;

        double salarioBase=2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            System.out.println("Quantidade de selecionados: "+ candidatosSelecionados);
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.printf("O candidato %s solicitou este valor de salário %s\n", candidato, salarioPretendido);
            if (salarioBase > salarioPretendido){
                System.out.printf("O candidadato %s foi selecionado para a vaga\n", candidato);
                candidatosSelecionados ++;

            }
            candidatoAtual ++;
        }

    }

    static double valorPretendido(){
        // pegando um valor aleatório de salário em um range para simular um input
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para candidato");
        } else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para candidato com contra proposta");
        }
        else {
            System.out.println("Aguardando demais candidatos");
        }
    }
}