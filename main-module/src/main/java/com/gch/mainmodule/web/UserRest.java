package com.gch.mainmodule.web;

import com.gch.mainmodule.entity.User;
import com.gch.mainmodule.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRest {

    @Resource
    UserMapper userMapper;

    @GetMapping("list")
    public String list(){
        List<User> users = userMapper.selectList(null);
        return users.toString();
    }
}
