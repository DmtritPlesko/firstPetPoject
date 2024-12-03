package com.example.demo.service.user;

import com.example.demo.dto.user.ShortUserDto;

import java.util.List;

public interface UserService {

    ShortUserDto getUserById(Long id);

    List<ShortUserDto> getAllUsers();
}
