package vn.gtel.qtudsso.domains;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.gtel.qtudsso.entities.UserEntity;
import vn.gtel.qtudsso.repositories.UserRepository;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDomain {

    private final UserRepository  userRepository;

    public Optional<UserEntity> findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public UserEntity  save(UserEntity user) {
       return  userRepository.save(user);
    }
}
