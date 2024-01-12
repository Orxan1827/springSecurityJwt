package com.example.springsecurityjwt.mapper;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.model.UserRequest;
import com.example.springsecurityjwt.model.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapRequestToAccount(UserRequest request){
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
    };

    public UserResponse mapEntityToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    };

}
