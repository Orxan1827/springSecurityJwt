package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.mapper.UserMapper;
import com.example.springsecurityjwt.model.UserRequest;
import com.example.springsecurityjwt.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User createUser(UserRequest request){
     return userRepository.save(userMapper.mapRequestToAccount(request));
    }

}
