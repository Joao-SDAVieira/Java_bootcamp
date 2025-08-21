package main.java.collections.set.OperacoesBasicas;

import java.util.*;

public class ConjuntoConvidado {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidado() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoDoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;

        for(Convidado convidado: convidadoSet){
            if(convidado.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = convidado;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet.toString());
    }

    public static void main(String[] args) {
        ConjuntoConvidado conjuntoConvidado = new ConjuntoConvidado();
        System.out.println("Existem "+ conjuntoConvidado.contarConvidados() + " Convidados");
        conjuntoConvidado.adicionarConvidado("João", 21);
        conjuntoConvidado.adicionarConvidado("ALberto", 19);
        conjuntoConvidado.adicionarConvidado("José", 28);
        conjuntoConvidado.adicionarConvidado("Congo", 19);
        conjuntoConvidado.exibirConvidados();
        System.out.println("Existem "+ conjuntoConvidado.contarConvidados() + " Convidados");



//
//        Set<Integer> meuHash = new HashSet<>();
//
//        meuHash.add(2);
//        meuHash.add(3);
//        meuHash.add(4);
//
//        List<Integer> minhaLista = new ArrayList<>();
//        minhaLista.add(1);
//        minhaLista.add(2);
//        minhaLista.add(3);
//        minhaLista.add(1);
//        System.out.println(minhaLista.get(1));
//
//        List<Integer> meuVector = new Vector<>();
//        meuVector.add(1);
//        meuVector.add(2);
//        meuVector.add(3);
//        meuVector.add(3);
//        System.out.println(meuVector.get(1));
//
//        Integer[] lista = {0,1,2,3};
//        System.out.println(lista.getClass() );
//
//        Convidado[] convidadosArray = new Convidado[5];
//        convidadosArray[0] = new Convidado("João", 21);
//        convidadosArray[1] = new Convidado("João", 21);
//        convidadosArray[2] = new Convidado("João", 21);
//
//        System.out.println(Arrays.toString(convidadosArray));

    }
}
