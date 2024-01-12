package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.config.PasswordEncoderConfig;
import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
        private final UserRepository userRepository;
        private final PasswordEncoderConfig passwordEncoderConfig;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found by username" + username));
           String password = passwordEncoderConfig.getBCryptPasswordEncoder().encode(user.getPassword());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), password, new ArrayList<>());
        }
    }

