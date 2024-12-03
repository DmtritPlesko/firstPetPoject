package com.example.demo.mapper;

import com.example.demo.dto.user.FullUserDto;
import com.example.demo.dto.user.ShortUserDto;
import com.example.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ShortUserDto toShortUserDto(User user);

    FullUserDto toFullUserDto(User user);

    User toUser(ShortUserDto shortUserDto);

    User toUser(FullUserDto fullUserDto);
}
