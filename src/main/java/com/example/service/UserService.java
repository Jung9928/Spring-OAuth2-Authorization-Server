package com.example.service;

import com.example.model.dto.UserDTO;
import com.example.model.entity.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void join(UserDTO userDTO) {
        UserEntity entity = new UserEntity();
        entity.setUsername(userDTO.getUsername());
        entity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        entity.setNickname(userDTO.getUsername());
        entity.setPhone(userDTO.getPhone());
        entity.setRole("ADMIN");

        userRepository.save(entity);
    }
}
