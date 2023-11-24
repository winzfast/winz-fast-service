package com.winzfast.controller.admin;


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
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user-list/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user-list/user/save/{id}")
    public ResponseEntity<String> saveOrUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.save(userDTO);
        return ResponseEntity.ok("Save/Update completed!");
    }

    @DeleteMapping("/user-list/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        String username = userDTO.getUsername();
        userService.delete(id);
        return ResponseEntity.ok("User " + username + " deleted!");
    }

    @GetMapping("/find-user/{input}")
    public ResponseEntity<Iterable<UserDTO>> findUser(@PathVariable String input) {
        return new ResponseEntity<>(userService.findUser(input), HttpStatus.OK);
    }
}
