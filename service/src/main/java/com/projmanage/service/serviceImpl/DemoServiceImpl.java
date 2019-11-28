package com.projmanage.service.serviceImpl;




import com.projmanage.data.dao.UserRoleMapper;
import com.projmanage.domain.entity.UserRole;
import com.projmanage.service.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserRoleMapper userRoleMapper;



    @Override
    public List<UserRole> sayHello() {
        List<UserRole> data = userRoleMapper.all();
        return data;
    }
}