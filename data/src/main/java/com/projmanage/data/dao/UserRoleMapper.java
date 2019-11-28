package com.projmanage.data.dao;

import com.projmanage.domain.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleMapper {
    /**
     * 查询所有的用户角色
     * @return
     */
    List<UserRole> all();
}