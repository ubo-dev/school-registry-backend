package com.ubo.schoolregistrybackend.service.user;

import com.ubo.schoolregistrybackend.dto.user.UserDto;
import com.ubo.schoolregistrybackend.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * Get the currently logged-in user.
     *
     * @return The currently logged-in user.
     */
    User getCurrentUser();

    /**
     * Get a user by their email address.
     *
     * @param email The email address of the user.
     * @return The user associated with the provided email address.
     */
    UserDto getUserByEmail(String email);

}
