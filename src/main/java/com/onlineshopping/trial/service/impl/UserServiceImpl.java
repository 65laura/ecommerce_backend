package com.onlineshopping.trial.service.impl;
import com.onlineshopping.trial.dto.UserDto;
import com.onlineshopping.trial.model.User;
import com.onlineshopping.trial.repositories.UserRepository;
import com.onlineshopping.trial.service.IUserServiceMapper;
import com.onlineshopping.trial.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final IUserServiceMapper userServiceMapper;



    @Override
    public User createUser(UserDto userdto) {
        User user = userServiceMapper.toUserServiceEntity(userdto);
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    @Override
    public User UpdateUser(UUID userId,UserDto userDto) {
        Optional<User> existingUser = userRepository.findById(userId);
        if(existingUser.isPresent()){
            throw new RuntimeException("User already exists");
        }
        User user = userServiceMapper.toUserServiceEntity(userDto);
        return userRepository.save(user);
    }

    @Override
    public User getSingleUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: "));
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow();
}}
