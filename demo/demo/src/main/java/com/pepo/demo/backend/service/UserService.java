package com.pepo.demo.backend.service;

import com.pepo.demo.backend.events.UserCreatedEvent;
import com.pepo.demo.backend.domain.User;
import com.pepo.demo.backend.dto.CreateUserRequestDTO;
import com.pepo.demo.backend.publisher.UserEventPublisher;
import com.pepo.demo.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserEventPublisher publisher;

    public UserService(UserRepository repository, UserEventPublisher publisher){
        this.repository = repository;
        this.publisher = publisher;
    }

    @Transactional
    public User create(CreateUserRequestDTO dto){
        User user = new User();
        user.setEmail(dto.email());

        User saved = repository.save(user);

        publisher.publishUserCreated(new UserCreatedEvent(saved.getId(), saved.getEmail()));

        return saved;
    }
}
