package com.lamdaschool.zoo.repository;

import com.lamdaschool.zoo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
