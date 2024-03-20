package com.ubo.schoolregistrybackend.dto.converter;

import com.ubo.schoolregistrybackend.dto.user.UserDto;
import com.ubo.schoolregistrybackend.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDtoConverter {

    public UserDto convertUserDto(User user) {
        return new UserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    public List<UserDto> convertUserDtoList(List<User> userList) {
        return userList.stream().map(this::convertUserDto).toList();
    }
}
