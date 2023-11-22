package com.test.winzfast.service.impl;

import com.test.winzfast.converter.LoginConverter;
import com.test.winzfast.converter.RegisterConverter;
import com.test.winzfast.dto.UserDTO;
import com.test.winzfast.exception.DuplicatedDataException;
import com.test.winzfast.model.User;
import com.test.winzfast.payload.request.LoginRequest;
import com.test.winzfast.payload.request.RegisterRequest;
import com.test.winzfast.payload.request.ResetPasswordRequest;
import com.test.winzfast.payload.response.LoginResponse;
import com.test.winzfast.payload.response.RegisterResponse;
import com.test.winzfast.payload.response.ResetPasswordResponse;
import com.test.winzfast.repository.UserRepository;
import com.test.winzfast.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Iterable<UserDTO> findAll() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), true)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(user, UserDTO.class));
    }

    @Override
    public void save(UserDTO userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String password = loginRequest.getPassword();
        if (password != null) {
            User user = userRepository.findByUsername(loginRequest.getUsername());
            if (user != null) {
                if (password.equals(user.getPassword())) {
                    return LoginConverter.loginEntityToDto(user);
                }
            }
        }
        return null;
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) throws DuplicatedDataException {
        List<User> userList = userRepository.findAll();

        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new DuplicatedDataException("Username is already exist!");
        } else if (registerRequest.getPassword() == null || registerRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be blank.");
        } else if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new DuplicatedDataException("The email already exists in the database");
        }

        User newUser = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .build();
        userRepository.save(newUser);
        return RegisterConverter.registerEntityToDto(newUser);
    }

    @Override
    public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
        String username = resetPasswordRequest.getUsername();
        String email = resetPasswordRequest.getEmail();
        String newPassword = resetPasswordRequest.getNewPassword();
        User user = userRepository.findByUsernameAndEmail(username, email);

        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return new ResetPasswordResponse("Reset password successfully!", HttpStatus.OK);
        } else {
            throw new RuntimeException("Invalid username/email!");
        }
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return modelMapper.map(user, UserDTO.class);
    }

}
