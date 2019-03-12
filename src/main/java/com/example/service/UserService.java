package com.example.service;

import com.example.mapper.test1.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService {
    @Autowired
    UserMapper userdao;

    public int addUser(User user){
        return userdao.insert(user);
    }
}
