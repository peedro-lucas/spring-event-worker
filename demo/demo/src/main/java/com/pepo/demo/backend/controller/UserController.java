package com.pepo.demo.backend.controller;


import com.pepo.demo.backend.domain.User;
import com.pepo.demo.backend.dto.CreateUserRequestDTO;
import com.pepo.demo.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController (UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create (@RequestBody CreateUserRequestDTO dto){
        return ResponseEntity.ok(service.create(dto));

    }
}
