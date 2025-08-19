package main.java.list.TesteComRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioCollection {
    private List<Usuario> usuarioList;

    public UsuarioCollection(){
        this.usuarioList = new ArrayList<>();
    }
    public void adicionarUsuario(int id, String username, String email){
        usuarioList.add(new Usuario(id, username, email));
    }

    public String consultarUsuarioPorId(int id){
        String usuarioResult = "Não encontrado";
        if(!this.usuarioList.isEmpty()){
            for(Usuario usuario: this.usuarioList){
                if(usuario.id() == id)
                    usuarioResult = usuario.toString();
            }
        }
        return usuarioResult;
    }

    public String ordenarPorId(){
        List<Usuario> usuariosOrdenados = this.usuarioList;
        Collections.sort(usuariosOrdenados);
        return usuariosOrdenados.toString();
    }

    public String ordenarPorNome(){
        List<Usuario> usuariosOrdenados = this.usuarioList;
        usuariosOrdenados.sort(new ComparatorUsuarioUsername());
        return usuariosOrdenados.toString();
    }

    public static void main(String[] args) {
        UsuarioCollection usuarioCollection = new UsuarioCollection();
        usuarioCollection.adicionarUsuario(2, "João3", "joao1@email.com");
        usuarioCollection.adicionarUsuario(3, "João7", "joao2@email.com");
        usuarioCollection.adicionarUsuario(20, "João1", "joao3@email.com");
        usuarioCollection.adicionarUsuario(5, "João2", "joao4@email.com");
        usuarioCollection.adicionarUsuario(5, "João5", "joao4@email.com");


        System.out.println(usuarioCollection.consultarUsuarioPorId(2));
        System.out.println(usuarioCollection.ordenarPorId());
        System.out.println(usuarioCollection.ordenarPorNome());

    }
}
