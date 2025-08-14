package com.example.login.Services;

import com.example.login.Models.User;
import com.example.login.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;




    public User login(User user){
       User expectedUser = userRepository.getUserByName(user.getUsername());
       if(expectedUser == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
       } else{
           if (expectedUser.getPassword().equals(user.getPassword())){
               return expectedUser;
           } else{
               throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong Password");
           }
       }
    }



    public User register(User user){
        User expectedUser = userRepository.getUserByName(user.getUsername());
        if(expectedUser != null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username already exists");
        }
        return userRepository.save(user);
    }



}
