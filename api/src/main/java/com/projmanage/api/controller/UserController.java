package com.projmanage.api.controller;


import com.projmanage.domain.entity.User;
import com.projmanage.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUser() {
        return userService.allUsers();
    }

    @PostMapping(value = "/register", produces = "application/json;charset=utf-8")
    public Map<String, Object> register(@RequestBody @Valid User user) {
        return userService.register(user);
    }

    @PostMapping(value = "/login", produces = "application/json;charset=utf-8")
    public Map<String, Object> login(
            @RequestParam("name") String name,
            @RequestParam("password") String password
    ) {
        return userService.login(name, password);
    }


}
