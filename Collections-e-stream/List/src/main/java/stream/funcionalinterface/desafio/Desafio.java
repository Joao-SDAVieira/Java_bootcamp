package main.java.stream.funcionalinterface.desafio;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Desafio {
    static List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 2,11,15,30,45,60);
//    static List<Integer> numeros = Arrays.asList(1, 1, 1, 1);
    public static void imprimeEmOrdemNumerica(){
        System.out.println(numeros.stream().sorted().toList());
    }

    public static void imprimeSomaNumerosPares(){
        System.out.println(numeros.stream().filter(
                numero -> numero %2 == 0
        ).reduce(
                0, (numero1, numero2) -> numero1 + numero2
        ));
    }

    public static void saoTodosPositivos(){
        System.out.println(numeros.stream().noneMatch(
                numero -> numero < 0
        ));

    }
    public static void removerImpares(){
        System.out.println(numeros.stream().filter(
                numero -> numero %2 != 0
        ).toList());
    }

    public static void mediaMenoresQueCinco(){
        List<Integer> numerosMaioresQueCinco = numeros.stream().filter(numero -> numero>5).toList();
        int media = numerosMaioresQueCinco.stream().reduce(
                        0, (numero1, numero2) -> numero1+ numero2
                    ) / numerosMaioresQueCinco.size();
        System.out.println(media);

        //versão do chatgpt, com mapToInt para ter as funções de media. Conseguindo também tratar caso lista vazia div/0:
        numeros.stream()
                .filter(numero -> numero > 5)
                .mapToInt(numero -> numero)
                .average()
                .ifPresentOrElse(
                        media2 -> System.out.println(media2),
                        () -> System.out.println("Nenhum número maior que 5")
                );
    }

    public static void existeNumeroMaiorQueZero(){
        System.out.println(numeros.stream().anyMatch(
                numero -> numero > 10
        ));
    }

    public static void segundoMaiorNumero(){
        System.out.println(numeros.stream().sorted().skip(numeros.size() -2).findFirst());
    }

    public static void somaNumeros(){
        System.out.println(numeros.stream().mapToInt(numero -> numero).sum());
    }

    public static void verificarUnicidade(){
        System.out.println(numeros.stream().distinct().count() == numeros.size());
    }

    public static void multiplosCincoImpares(){
        System.out.println(numeros.stream().filter(
                numero -> (numero % 3 == 0 || numero%5 == 0) && numero%2 != 0
        ).toList());
    }

    public static void somaQuadrados(){
        System.out.println(numeros.stream().mapToInt(numero -> numero * numero).sum());
    }

    public static void filtrarIntervalo(int inicio, int fim){
        System.out.println(numeros.stream().filter(numero -> numero>= inicio && numero<= fim).toList());
    }

    public static void separarImparPar(){
        ImparesPares imparesPares = new ImparesPares();
        Consumer<Integer> popularLista = numero -> {
            if(numero%2==0) imparesPares.setPares(numero);
            else {imparesPares.setImpares(numero);}
        };

        numeros.forEach(popularLista);
        System.out.println(imparesPares);

        // o próximo vi no gepeto
        Map<String, List<Integer>> grupos = numeros.stream().collect(
                Collectors.groupingBy(n -> n%2 == 0 ? "Pares": "Impares")
        );
        System.out.println(grupos);
    }

    public static void verificarSeTodosSaoIguais(){
        System.out.println(numeros.stream().distinct().count() ==1);
    }

    public static void numerosDivisiveisPorSeisECinco(){
        System.out.println(
                numeros.stream().reduce(
                        0, (numero1, numero2) ->
                                ((numero1%5 == 0 && numero1%3 == 0) && (numero2%5 == 0 && numero2%3 == 0))? numero1 + numero2: 0
                )
        );
    }

    public static void main(String[] args) {
        verificarSeTodosSaoIguais();

        imprimeEmOrdemNumerica();
        imprimeSomaNumerosPares();
        saoTodosPositivos();
        removerImpares();
        mediaMenoresQueCinco();
        existeNumeroMaiorQueZero();
        segundoMaiorNumero();
        somaNumeros();
        verificarUnicidade();
        multiplosCincoImpares();
        somaQuadrados();
        filtrarIntervalo(5,9);
        separarImparPar();
        verificarSeTodosSaoIguais();
        numerosDivisiveisPorSeisECinco();

    }
}
