package main.java.collections.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoUsuario {
    private List<Usuario> usuarioList;

    public OrdenacaoUsuario(){
        this.usuarioList = new ArrayList<>();
    }

    public void adicionarUsuario(double altura, int idade, String nome){
        usuarioList.add(new Usuario(altura, idade, nome));
    }

    public List<Usuario> ordenarPorIdade(){
        List<Usuario> usuariosPorIdade = new ArrayList<>(usuarioList);
        Collections.sort(usuariosPorIdade);
        return usuariosPorIdade;
    }

    public List<Usuario> ordenarPorAltura(){
        List<Usuario> usuarioPorAltura = new ArrayList<>(usuarioList);
        Collections.sort(usuarioPorAltura, new ComparatorPorAltura());
        return usuarioPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoUsuario ordenacaoUsuario = new OrdenacaoUsuario();
        ordenacaoUsuario.adicionarUsuario(1.56, 20,"Nome 1") ;
        ordenacaoUsuario.adicionarUsuario(1.80, 30,"Nome 2") ;
        ordenacaoUsuario.adicionarUsuario(1.70, 25,"Nome 3") ;
        ordenacaoUsuario.adicionarUsuario(1.56, 17,"Nome 4") ;

        System.out.println(ordenacaoUsuario.ordenarPorAltura());
        System.out.println(ordenacaoUsuario.ordenarPorIdade());

    }
}
