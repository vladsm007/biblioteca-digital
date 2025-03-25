package br.com.vtorres.biblioteca_digital.service;

import br.com.vtorres.biblioteca_digital.entities.User;
import br.com.vtorres.biblioteca_digital.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()){
            throw new IllegalArgumentException("O nome do usuário não pode ficar vazio.");
        }if (exitsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email já está em uso.");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
        System.out.println("Usuario deletado com sucesso.");
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public boolean exitsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
