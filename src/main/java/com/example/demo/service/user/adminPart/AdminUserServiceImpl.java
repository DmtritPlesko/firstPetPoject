package com.example.demo.service.user.adminPart;

import com.example.demo.dto.user.FullUserDto;
import com.example.demo.dto.user.ShortUserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.user.publicPart.PublicUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminUserServiceImpl implements AdminUserService {

    final UserRepository repository;
    final UserMapper mapper;
    final PublicUserService publicUserService;

    @Override
    public ShortUserDto addUser(FullUserDto user, Long id) {
        User user1 = mapper.toUser(user);
        user1.setId(id);
        return mapper.toShortUserDto(repository.save(user1));
    }

    @Override
    public ShortUserDto updateUser(FullUserDto user, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ShortUserDto getUserById(Long id) {
        return publicUserService.getUserById(id);
    }

    @Override
    public List<ShortUserDto> getAllUsers() {
        return publicUserService.getAllUsers();
    }
}
