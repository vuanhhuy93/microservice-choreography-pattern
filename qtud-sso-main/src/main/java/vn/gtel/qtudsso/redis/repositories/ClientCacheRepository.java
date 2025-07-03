package vn.gtel.qtudsso.redis.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.gtel.qtudsso.redis.entities.Client;

public interface ClientCacheRepository extends CrudRepository<Client, String> {
}
