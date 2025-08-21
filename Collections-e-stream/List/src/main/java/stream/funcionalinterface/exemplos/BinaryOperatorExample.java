package main.java.stream.funcionalinterface.exemplos;

import java.util.Arrays;
import java.util.List;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);


        int resultado = numeros.stream().reduce(
                0, (num1, num2) -> num1 + num2
        );

        System.out.println(resultado);


        List<String> palavras = Arrays.asList("Essa", " Frase", " deve" , " ser", " concatenada");

        String frase = palavras.stream().reduce("", (palavra1, palavra2) -> palavra1+palavra2);
        System.out.println(frase);
    }
}
