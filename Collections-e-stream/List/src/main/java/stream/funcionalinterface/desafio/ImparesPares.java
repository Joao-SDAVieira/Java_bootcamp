package main.java.stream.funcionalinterface.desafio;

import java.util.ArrayList;
import java.util.List;

public class ImparesPares {
    List<Integer> impares;
    List<Integer> pares;

    public ImparesPares() {
        this.impares = new ArrayList<>();
        this.pares = new ArrayList<>();
    }

    public List<Integer> getImpares() {
        return impares;
    }

    public void setImpares(int impar) {
        this.impares.add(impar);
    }

    public List<Integer> getPares() {
        return pares;
    }

    public void setPares(int par) {
        this.pares.add(par);
    }

    @Override
    public String toString() {
        return "ImparesPares{" +
                "impares=" + impares +
                ", pares=" + pares +
                '}';
    }
}
