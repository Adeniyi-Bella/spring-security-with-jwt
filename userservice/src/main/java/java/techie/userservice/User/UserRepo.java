package java.techie.userservice.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.techie.userservice.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
