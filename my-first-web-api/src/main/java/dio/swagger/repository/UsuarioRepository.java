package dio.swagger.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dio.swagger.model.User;

@Repository
public class UsuarioRepository {

    public void save(User user) {
        if (user.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório.");
        } else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório.");
        }
        System.out.println(user);
    }

    public void deleteById(Integer id) {
        System.out.printf(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário.", id));
        System.out.println(id);
    }

    public List<User> findAll() {
        System.out.println("LIST - Listando os usuários do sistema.");
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User("samuelr", "abc12345"));
        usuarios.add(new User("frank", "yyhe665400"));
        usuarios.add(new User("denisr", "woiejih33"));

        return usuarios;
    }

    public User findById(User user) {
        System.out.printf(String.format("FIND/id - Recebendo o id %d para localizar um usuário."));
        return new User("samuelr", "abc12345");
    }

    public User findByUsername(String username) {
        System.out
                .println(String.format("FIND/username - Recebendo o username %s para localizar um usuário.", username));
        return new User("samuelr", "abc12345");
    }
}
