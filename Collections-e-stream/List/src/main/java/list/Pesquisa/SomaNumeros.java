package main.java.list.Pesquisa;

import java.util.*;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros(){
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for(int numero: this.numeros){
            soma +=numero;
        }
        return soma;
    }

    public int encontrarMaiornumero(){
        if(this.numeros.isEmpty()){
            System.out.println("Não há números!");
            return 0;
        }

        if(this.numeros.toArray().length < 2){
            return this.numeros.getFirst();
        }
        int maiorNumero = 0;
        for(int idx=0; idx<this.numeros.toArray().length; idx++){
            if(maiorNumero<this.numeros.get(idx)){
                maiorNumero = this.numeros.get(idx);
            }
        }

        return maiorNumero;
    }

    public int encontrarMenorNumero(){
        if(this.numeros.isEmpty()){
            System.out.println("Não há números!");
            return 0;
        }

        if(this.numeros.toArray().length < 2){
            return this.numeros.getFirst();
        }
        int menorNumero = 0;
        for(int idx=0; idx<this.numeros.toArray().length; idx++){
            if (idx == 0){
                menorNumero = this.numeros.get(idx);
            }
            if(menorNumero>this.numeros.get(idx)){
                menorNumero = this.numeros.get(idx);
            }
        }

        return menorNumero;
    }
    public void exibirNumeros(){
        System.out.println(Arrays.toString(this.numeros.toArray()));
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
//        somaNumeros.adicionarNumero(1);
//        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(20);

        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(35);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(8);

        somaNumeros.exibirNumeros();
        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.encontrarMenorNumero());
        System.out.println(somaNumeros.encontrarMaiornumero());
    }
}
