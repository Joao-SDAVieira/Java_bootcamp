package main.java.stream.funcionalinterface.exemplos;

import java.util.Arrays;
import java.util.List;

public class FunctionExample {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 2, 3);


        List<String> numerosParaString = numeros.stream().map(
                numero -> numero.toString()).toList();

        System.out.println(numerosParaString);
    }
}
