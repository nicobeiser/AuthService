package com.example.login.Configuration;

import com.example.login.Services.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class AuthBeans {

    private final MyUserDetailsService uds;
    private final PasswordEncoder passwordEncoder;

    public AuthBeans(MyUserDetailsService uds, PasswordEncoder encoder) {
        this.uds = uds;
        this.passwordEncoder = encoder;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(uds); //le digo al auth provider que uds usar
        p.setPasswordEncoder(passwordEncoder); // le digo al auth provider que password encoder usar
        return p;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration cfg) throws Exception {
        return cfg.getAuthenticationManager();
    }


}
