package dev.bazzi.AmazonBackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional()
public interface UserRepository extends JpaRepository<User,Long> {

    void deleteById(Long id);
    Optional<User> findByEmail(String email);
}