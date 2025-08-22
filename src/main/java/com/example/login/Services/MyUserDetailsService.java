package com.example.login.Services;

import com.example.login.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.login.Models.User u = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
        // mapeá tu entidad a UserDetails:
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getUsername())
                .password(u.getPassword())
                .authorities(u.getRoles().toArray(String[]::new))
                .accountLocked(false)
                .disabled(false)
                .build();
    }



}
