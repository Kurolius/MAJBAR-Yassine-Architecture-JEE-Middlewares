package ma.enset.jpaenset.repositories;

import ma.enset.jpaenset.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String userName);
    List<User> findAll();
}
