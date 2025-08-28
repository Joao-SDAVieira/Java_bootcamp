package app.service;

import app.domain.model.User;

public interface UserService{
    User findById(Long id);

    User create(User userToCreate);
}
