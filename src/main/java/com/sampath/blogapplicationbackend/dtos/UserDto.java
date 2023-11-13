package com.sampath.blogapplicationbackend.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min=4,message = "username must be minimum of 4")
    private String name;

    @Email(message = "email is not valid!!")
    private String email;

    @NotEmpty
    @Size(min = 3,max = 10,message = "password must be min of 3 chars and max of 10 char")
    private String password;

    @NotEmpty
    private String about;
}
