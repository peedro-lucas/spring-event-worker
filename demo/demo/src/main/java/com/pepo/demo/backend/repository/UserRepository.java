package com.pepo.demo.backend.repository;

import com.pepo.demo.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
