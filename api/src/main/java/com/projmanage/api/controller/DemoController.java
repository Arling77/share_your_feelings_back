package com.projmanage.api.controller;


import com.projmanage.domain.entity.UserRole;
import com.projmanage.service.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
@RestController注解比较适用于Restful风格的API，如果接口只关心数据，不做server render，就可以使用@RestController注解。
        如果接口需要返回模版页面，则需要使用@Controller注解。
@GetMapping注解，是将HTTP Get请求映射到我们自定义的hello方法上。
*/
@RestController
@RequestMapping(value = "/us")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public List<UserRole> hello() {
        return demoService.sayHello();
    }
}