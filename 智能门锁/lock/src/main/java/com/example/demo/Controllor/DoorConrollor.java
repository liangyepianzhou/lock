package com.example.demo.Controllor;

import com.example.demo.Util.Resultbean;
import com.example.demo.mapper.LocksMapper;
import com.example.demo.pojo.Locks;
import com.example.demo.service.socket.ClientSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/door")
@Controller
public class DoorConrollor {
    @Autowired
    LocksMapper locksMapper;
    @RequestMapping("/oprn")
    @ResponseBody
    public Resultbean opendoor(String lock_id) throws IOException {
        Locks locks= locksMapper.selectByPrimaryKey(lock_id);
        ClientSocketService clientSocketService =new ClientSocketService(locks.getIp());
        clientSocketService.addtemppass("open");
        return Resultbean.success();
    }
    @RequestMapping("/temp")
    @ResponseBody
    public Resultbean temp(String temp , String lock_id, Date date) throws IOException {
        Locks locks= locksMapper.selectByPrimaryKey(lock_id);
        ClientSocketService clientSocketService =new ClientSocketService(locks.getIp());
        clientSocketService.addtemppass("111");
        clientSocketService.addtemppass(temp);
        clientSocketService.addtemppass(date.toString());
        return Resultbean.success();
    }
    @RequestMapping("/advice")
    @ResponseBody
    public Resultbean advice(String lock_id){
        Locks locks=  locksMapper.selectByPrimaryKey(lock_id);
        Map<String,Object> map=new HashMap<>();
        map.put("advice", locks.getAdvice());
        return Resultbean.success(map);
    }


}
