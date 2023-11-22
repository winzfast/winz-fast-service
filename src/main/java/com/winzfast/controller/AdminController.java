package com.winzfast.controller;


import com.winzfast.dto.UserDTO;
import com.winzfast.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;

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
