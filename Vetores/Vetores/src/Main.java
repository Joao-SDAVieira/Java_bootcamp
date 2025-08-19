import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] meuVetor = {3,6,4,3};
        System.out.println("Quantidade de valores "+ meuVetor.length);
        for (int c=0; c<=meuVetor.length-1; c++){
            System.out.println(meuVetor[c]);
        }

        String[] prefixosMes = {
                "Jan", "Fev", "Mar", "Abr", "Mai", "Jun",
                "Jul", "Ago", "Set", "Out", "Nov", "Dez"
        };

        // Vetor com último dia de cada mês
        int[] ultimoDiaMes = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        for(int c=0;c<ultimoDiaMes.length; c++){
            System.out.println("O mês de " + prefixosMes[c] + " possui: "+ultimoDiaMes[c]+" dias");
        }

        int[] novoVetor = {3,6,4,3};
//        Arrays.sort(novoVetor);

        for (int valor: novoVetor){
            System.out.println(valor);
        }

        int value = Arrays.binarySearch(novoVetor, 4);

        System.out.println("Valor encontrado na posição: "+ value);

        // criando vetor vazio
        int[] vetorVazio = new int[20];
        Arrays.fill(vetorVazio, 0);
        for (int valor: vetorVazio){
            System.out.println(valor);}
    }
}