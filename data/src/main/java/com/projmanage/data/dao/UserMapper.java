package com.projmanage.data.dao;

import com.projmanage.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    User getUserByName(String name);

    void insertUser(User user);

    List<User> allUsers();
}
