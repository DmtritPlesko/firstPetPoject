package com.example.demo.service.user.adminPart;

import com.example.demo.dto.user.FullUserDto;
import com.example.demo.dto.user.ShortUserDto;
import com.example.demo.model.User;
import com.example.demo.service.user.UserService;

public interface AdminUserService extends UserService {

    ShortUserDto addUser(FullUserDto user, Long id);

    ShortUserDto updateUser(FullUserDto user, Long id);

    void deleteUser(Long id);
}
