package com.lamdaschool.zoo.controller;

import com.lamdaschool.zoo.model.User;
import com.lamdaschool.zoo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

    @Autowired
    // private UserService userService;
    private UserRepository userrepos;

    @GetMapping("/users")
    public List<User> listAllUsers()
    {
        return userrepos.findAll();
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User newuser) throws URISyntaxException
    {
        return userrepos.save(newuser);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable long id)
    {
        var foundUser = userrepos.findById(id);
        if (foundUser.isPresent())
        {
            userrepos.deleteById(id);

            return "{" + "\"id\":"   + foundUser.get().getId() +
                    ",\"username\":" + "\"" + foundUser.get().getUsername() + "\"" +
                    ",\"role\":" + foundUser.get().getAuthority() + "}";
        }
        else
        {
            return null;
        }
    }

}
