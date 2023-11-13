package com.sampath.blogapplicationbackend.services.interfaces;

import com.sampath.blogapplicationbackend.dtos.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);


}
