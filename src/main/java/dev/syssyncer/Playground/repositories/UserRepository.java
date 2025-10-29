package dev.syssyncer.Playground.repositories;

import dev.syssyncer.Playground.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByEmail(String email);
}
