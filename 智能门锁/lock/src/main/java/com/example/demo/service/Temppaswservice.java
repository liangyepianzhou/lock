package com.example.demo.service;

import com.example.demo.mapper.TemppaswMapper;
import com.example.demo.pojo.Temppasw;
import com.example.demo.pojo.TemppaswExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class Temppaswservice {
    @Autowired
    TemppaswMapper temppaswMapper;

    public static int  ids=1;

    public List<Temppasw> quiryforlist(int lock_id){
        List<Temppasw> list=new LinkedList<>();
        TemppaswExample temppaswExample=new TemppaswExample();
        temppaswExample.setOrderByClause("time");
        temppaswExample.setDistinct(true);
        TemppaswExample.Criteria criteria = temppaswExample.createCriteria();
        criteria.andLockIdEqualTo(lock_id);

        list =temppaswMapper.selectByExample(temppaswExample);
        return list;
    }
    public Boolean delete(int lock_id ,int id){
        TemppaswExample temppaswExample =new TemppaswExample();
        temppaswExample.setDistinct(true);
        TemppaswExample.Criteria criteria =temppaswExample.createCriteria();
        criteria.andLockIdEqualTo(lock_id);
        criteria.andIdEqualTo(id);
        temppaswMapper.deleteByExample(temppaswExample);
        return true;
    }
    public boolean add(Temppasw temppasw){
        temppaswMapper.insert(temppasw);
        return true;

    }


}
