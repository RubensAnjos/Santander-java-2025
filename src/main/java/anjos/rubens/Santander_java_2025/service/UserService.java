package anjos.rubens.Santander_java_2025.service;

import anjos.rubens.Santander_java_2025.domain.model.User;

public interface UserService {
    User findByid(long id);

    User create (User userToCreate);
}
