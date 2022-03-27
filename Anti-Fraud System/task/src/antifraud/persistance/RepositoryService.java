package antifraud.persistance;

import antifraud.exception.UserExistsException;
import antifraud.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryService {
    UserRepository userRepository;

    @Autowired
    public RepositoryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userEntity) {
        if (userRepository.existsByUsernameIgnoreCase(userEntity.getUsername())) {
            throw new UserExistsException();
        }
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public void delete(String username) {
        UserEntity user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(UserNotFound::new);
        userRepository.delete(user);
    }
}
