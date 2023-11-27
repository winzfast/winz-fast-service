package com.winzfast.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winzfast.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String avatar;
    private String address;
}
