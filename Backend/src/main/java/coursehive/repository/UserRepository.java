package coursehive.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coursehive.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);

}