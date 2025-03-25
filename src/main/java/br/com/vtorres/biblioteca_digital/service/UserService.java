package br.com.vtorres.biblioteca_digital.service;

import br.com.vtorres.biblioteca_digital.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> findUserByName(String name);
    boolean exitsByEmail(String email);

}
