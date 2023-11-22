package com.test.winzfast.controller;

import com.test.winzfast.dto.UserDTO;
import com.test.winzfast.model.User;
import com.test.winzfast.repository.UserRepository;
import com.test.winzfast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user-list")
    public ResponseEntity<Iterable<UserDTO>> getUserList() {
        return new ResponseEntity<Iterable<UserDTO>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user-list/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user-list/user/{id}/save")
    public ResponseEntity<String> saveOrUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.save(userDTO);
        return ResponseEntity.ok("Save/Update completed!");
    }

    @DeleteMapping("/user-list/user/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        String username = userDTO.getUsername();
        userService.delete(id);
        return ResponseEntity.ok("User " + username + " deleted!");
    }
}
