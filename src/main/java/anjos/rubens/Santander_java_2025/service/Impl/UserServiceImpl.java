package anjos.rubens.Santander_java_2025.service.Impl;

import anjos.rubens.Santander_java_2025.domain.model.User;
import anjos.rubens.Santander_java_2025.domain.repository.UserRepository;
import anjos.rubens.Santander_java_2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findByid(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exist.");
        }
        return userRepository.save(userToCreate);
    }
}
