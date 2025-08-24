package orm.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import orm.aula.model.User;
import orm.aula.repository.UserRepository;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = repository.filtrarPorNome("João");
        for(User user: users){
            System.out.println(user);
        }

        for(User userDb: repository.findAll()){
            System.out.println(userDb);
        }
    }
}
