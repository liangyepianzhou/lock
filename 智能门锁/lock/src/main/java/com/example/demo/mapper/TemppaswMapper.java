package com.example.demo.mapper;

import com.example.demo.pojo.Temppasw;
import com.example.demo.pojo.TemppaswExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemppaswMapper {
    long countByExample(TemppaswExample example);

    int deleteByExample(TemppaswExample example);

    int deleteByPrimaryKey(Integer ids);

    int insert(Temppasw record);

    int insertSelective(Temppasw record);

    List<Temppasw> selectByExample(TemppaswExample example);

    Temppasw selectByPrimaryKey(Integer ids);

    int updateByExampleSelective(@Param("record") Temppasw record, @Param("example") TemppaswExample example);

    int updateByExample(@Param("record") Temppasw record, @Param("example") TemppaswExample example);

    int updateByPrimaryKeySelective(Temppasw record);

    int updateByPrimaryKey(Temppasw record);
}