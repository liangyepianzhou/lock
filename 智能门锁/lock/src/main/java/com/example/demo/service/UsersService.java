package com.example.demo.service;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersService {
    @Autowired
    UsersMapper usersMapper;

    public UsersMapper getUsersMapper() {
        return usersMapper;
    }
    @Autowired
           Users users;
//    查询并返回一个users对象
    public Users qurityforuser(int id){
        users =usersMapper.selectByPrimaryKey(id);
        return users;
    }
    public boolean delete(int id){
        int i = usersMapper.deleteByPrimaryKey(id);
        if(i==1)
        {return true;}
        else {return false;}
    }
    public boolean add(Users users){
        usersMapper.insert(users);
        return true;
    }


}
