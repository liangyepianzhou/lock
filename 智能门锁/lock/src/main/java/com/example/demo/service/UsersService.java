package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.Util.JedisClusterUtil;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

@Component
public class UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    JedisClusterUtil jedisClusterUtil;
    public UsersMapper getUsersMapper() {
        return usersMapper;
    }
    @Autowired
           Users users;
//    查询并返回一个users对象
    public Users qurityforuser(String iphone){
        JedisCluster jedisCluster =jedisClusterUtil.getJedisCluster();
        String usersString =jedisCluster.get(iphone);
        if(usersString==null)
        {
            users =usersMapper.selectByPrimaryKey(iphone);
             usersString = JSON.toJSONString(users);
            jedisCluster.append(iphone,usersString);
        }
        else {
            users =JSON.parseObject(usersString,Users.class);
        }
        return users;
    }
    public boolean delete(String iphone){
        int i = usersMapper.deleteByPrimaryKey(iphone);

        if(i==1)
        {return true;}
        else {return false;}
    }
    public boolean add(Users users){
        usersMapper.insert(users);
        return true;
    }


}
