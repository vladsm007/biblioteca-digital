package br.com.vtorres.biblioteca_digital.controller;


import br.com.vtorres.biblioteca_digital.entities.User;
import br.com.vtorres.biblioteca_digital.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //end-point para a criação de novos usuários
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

   @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
       Map<String, String> deletedMessage = new HashMap<>();
       deletedMessage.put("mensagem: ", "deletado com sucesso");
       deletedMessage.put("id", id.toString());
        userService.deleteUser(id);
        return ResponseEntity.ok(deletedMessage);
   }

   @GetMapping("/search")
    public ResponseEntity<List<User>> findUserByName (@RequestParam String name) {
        List<User> users = userService.findUserByName(name);
        return ResponseEntity.ok(users);
   }

}