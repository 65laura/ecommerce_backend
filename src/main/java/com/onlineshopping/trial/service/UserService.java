package com.onlineshopping.trial.service;
import com.onlineshopping.trial.dto.UserDto;
import com.onlineshopping.trial.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
public interface UserService extends UserDetailsService{
    User createUser(UserDto userdto) ;
     Page<User> getAllUsers(Pageable pageable);
    User UpdateUser(UUID userId,UserDto userDto);
    User getSingleUser(UUID userId);
    void deleteUser(UUID userId);

}

