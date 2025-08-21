package main.java.collections.list.Ordenacao;

public record Numero(int numero) implements Comparable<Numero>{
    public int numero(){
        return  numero;
    }

    @Override
    public int compareTo(Numero numeroObj){
        System.out.println(numero + "-" + numeroObj.numero());
        return Integer.compare(numero, numeroObj.numero());
    }
}