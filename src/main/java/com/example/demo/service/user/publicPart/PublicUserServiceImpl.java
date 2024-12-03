package com.example.demo.service.user.publicPart;

import com.example.demo.dto.user.ShortUserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.book.publicPart.PublicBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublicUserServiceImpl implements PublicUserService {

    final UserRepository repository;
    final UserMapper mapper;

    @Override
    public ShortUserDto getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        return mapper.toShortUserDto(user.get());
    }

    @Override
    public List<ShortUserDto> getAllUsers() {
        return repository.findAll().stream()
                .map(mapper::toShortUserDto)
                .toList();
    }
}
