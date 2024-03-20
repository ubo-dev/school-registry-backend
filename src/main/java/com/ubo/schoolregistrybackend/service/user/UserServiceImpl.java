package com.ubo.schoolregistrybackend.service.user;

import com.ubo.schoolregistrybackend.dto.converter.UserDtoConverter;
import com.ubo.schoolregistrybackend.dto.user.UserDto;
import com.ubo.schoolregistrybackend.model.User;
import com.ubo.schoolregistrybackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof User user) {
            return user;
        }

        return new User();
    }

    public UserDto getUserByEmail(String email) {
        return userDtoConverter.convertUserDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with given email: " + email)));
    }
}
