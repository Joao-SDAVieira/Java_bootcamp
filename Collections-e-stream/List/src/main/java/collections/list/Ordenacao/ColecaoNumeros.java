package main.java.collections.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ColecaoNumeros {
    private List<Numero> numeroList;

    public ColecaoNumeros(){
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeroList.add(new Numero(numero));
    }

    public List<Numero> ordenarNumerosCrescente(){
        List<Numero> numerosOrdenados = new ArrayList<>(numeroList);
        Collections.sort(numerosOrdenados);
        return numerosOrdenados;
    }

    public List<Numero> ordenarNumerosDecrescente(){
        Vector<Numero> numerosOrdenados = new Vector<>(numeroList);
        Collections.sort(numerosOrdenados, Collections.reverseOrder());
        return numerosOrdenados;
    }

    public static void main(String[] args) {
        ColecaoNumeros colecaoNumeros = new ColecaoNumeros();
        colecaoNumeros.adicionarNumero(20);
        colecaoNumeros.adicionarNumero(3);
        colecaoNumeros.adicionarNumero(1);
        colecaoNumeros.adicionarNumero(2);
        colecaoNumeros.adicionarNumero(7);
        colecaoNumeros.adicionarNumero(3);
        System.out.println(colecaoNumeros.ordenarNumerosCrescente());
        System.out.println(colecaoNumeros.ordenarNumerosDecrescente());
    }
}