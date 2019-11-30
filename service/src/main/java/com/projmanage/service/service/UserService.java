package com.projmanage.service.service;

import com.projmanage.domain.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, Object> login(String name, String password);

    Map<String, Object> register(User user);

    List<User> allUsers();
}
