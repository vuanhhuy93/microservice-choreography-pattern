package vn.gtel.qtudsso.redis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vn.gtel.qtudsso.redis.entities.Token;

public interface TokenRepository extends CrudRepository<Token, String> {
}
