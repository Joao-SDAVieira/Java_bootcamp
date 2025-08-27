package curso.web.api.repository;

import curso.web.api.handler.BussinessException;
import curso.web.api.handler.CampoObrigatorioException;
import curso.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void save(Usuario usuario){
        if(usuario.getLogin() == null){
            throw new CampoObrigatorioException("login");
        }
        if(usuario.getId() == null)
            System.out.println("Save - Recebendo usuário em repositório");
        else{
            System.out.println("Update - Recebendo usuário em repositório");
        }
        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.printf("Delete/id - Recebendo o id: %d para excluir%n", id);;
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("List - listando usuários");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Jo", "password"));
        usuarios.add(new Usuario("Ão", "masterpass"));
        return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.printf("Find/id - recebendo o id: %d para localizar um usuario", id);
        return new Usuario("Jo", "password");
    }
    public Usuario findByUsername(String username){
        System.out.printf("Find/username - recebendo o username: %s para localizar um usuario", username);
        return new Usuario("Jo", "password");
    }
}
