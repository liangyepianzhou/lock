package com.example.demo.mapper;

import com.example.demo.pojo.Locks;
import com.example.demo.pojo.LocksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LocksMapper {
    long countByExample(LocksExample example);

    int deleteByExample(LocksExample example);

    int deleteByPrimaryKey(String lockId);

    int insert(Locks record);

    int insertSelective(Locks record);

    List<Locks> selectByExample(LocksExample example);

    Locks selectByPrimaryKey(String lockId);

    int updateByExampleSelective(@Param("record") Locks record, @Param("example") LocksExample example);

    int updateByExample(@Param("record") Locks record, @Param("example") LocksExample example);

    int updateByPrimaryKeySelective(Locks record);

    int updateByPrimaryKey(Locks record);
}