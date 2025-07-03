package vn.gtel.qtudsso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.gtel.qtudsso.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, String> {
}
