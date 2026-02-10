package com.pepo.demo.backend.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, unique = true)
    private String email;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){return email ;};

    public Long getId(){return id;};


}
