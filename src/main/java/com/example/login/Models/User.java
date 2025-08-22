package com.example.login.Models;

import jakarta.persistence.*;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "Users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true)
    private String username;

    @Column (nullable = false)
    private String passwordHash;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"))
    @Column(name="role")                  // p.ej. "ROLE_USER", "ROLE_ADMIN"
    private Set<String> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password) {
        this.passwordHash = password;
    }

    public Set<String> getRoles() { return roles; }

    public void setRoles(Set<String> roles) { this.roles = roles; }


}