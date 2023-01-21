package org.liceum.edm.service;


import org.liceum.edm.dto.UserDto;
import org.liceum.edm.entity.UserEntity;
import org.liceum.edm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = new UserEntity()
                .setName(userDto.getName())
                .setBirthDay(userDto.getBirthDay())
                .setUserId(UUID.randomUUID().toString())
                .setCreatedAt(LocalDateTime.now());

        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
