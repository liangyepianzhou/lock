package com.example.demo;

import com.example.demo.mapper.TemppaswMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ConfigurationPropertiesScan
@MapperScan
class DemoApplicationTests {
    @Autowired
    TemppaswMapper temppaswMapper;
    @Test
    void contextLoads() {
        Integer i=1;
        temppaswMapper.deleteByPrimaryKey(i);

    }

}
