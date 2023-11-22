package com.winzfast.controller;

import com.winzfast.dto.UserDTO;
import com.winzfast.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/{id}/save")
    public ResponseEntity<String> saveOrUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.save(userDTO);
        return ResponseEntity.ok("Save/Update completed!");
    }

}
