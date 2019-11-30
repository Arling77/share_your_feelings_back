package com.projmanage.service.serviceImpl;

import com.projmanage.data.dao.UserMapper;
import com.projmanage.domain.entity.User;
import com.projmanage.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = userMapper.getUserByName(name);
        if (null == user)
            map.put("error", "用户名不存在");
        else {
            String psw = user.getPassword();


            String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5.equals(psw)) {
                user.setPassword(null);
                map.put("success", true);
                map.put("user", user);
            } else {
                map.put("error", "密码错误");
            }


        }
        return map;
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();
        User tmp = userMapper.getUserByName(user.getName());

        if (tmp == null) {
            String md5 = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5);
            userMapper.insertUser(user);
            map.put("success", "true");
        } else {
            map.put("error", "用户名已存在");
        }

        return map;

    }

    @Override
    public List<User> allUsers() {
        List<User> data = userMapper.allUsers();
        return data;
    }
}
