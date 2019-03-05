package com.lamdaschool.zoo.service;

import com.lamdaschool.zoo.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}