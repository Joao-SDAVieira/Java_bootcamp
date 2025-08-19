package main.java.list.TesteComRecord;

import java.util.Comparator;

public record Usuario(int id, String username, String email) implements Comparable<Usuario> {
    @Override
    public int id() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Usuario usuario){
        return Integer.compare(id, usuario.id());
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public String email() {
        return email;
    }
}
class ComparatorUsuarioUsername implements Comparator<Usuario>{
    @Override
    public int compare(Usuario usuario1, Usuario usuario2){
        System.out.println("Comparando: "+ usuario1+" Com: " +usuario2);
        return usuario1.username().compareTo(usuario2.username());
    }
}
