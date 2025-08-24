package orm.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import orm.aula.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameContaining(String name);

    User findByUsername(String username);

    @Query("SELECT user FROM User user WHERE user.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name") String name);
}
