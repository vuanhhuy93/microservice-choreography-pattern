package vn.gtel.qtudsso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.gtel.qtudsso.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}