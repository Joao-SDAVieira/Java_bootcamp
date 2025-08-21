package main.java.stream.funcionalinterface.exemplos;

import java.util.Arrays;
import java.util.List;

public class PredicateExemple {
    public static void main(String[] args) {
        List<String> linguagens = Arrays.asList("Python", "Java", "Kotlin", "javascript", "C", "C++", "cobol");

        List<String> linguagensFiltradas =  linguagens.stream().filter(s -> s.length()>5).toList();

        System.out.println(linguagensFiltradas);
    }
}
