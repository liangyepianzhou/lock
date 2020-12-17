package com.example.demo;

import com.example.demo.mapper.LocksMapper;
import com.example.demo.pojo.Locks;
import com.example.demo.service.socket.ServerSocketdThread;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.ServerSocket;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@SpringBootTest
@ConfigurationPropertiesScan
@MapperScan
class DemoApplicationTests {
    @Autowired
    LocksMapper locksMapper;
    @Autowired
    Locks locks;
    @Autowired
    ServerSocketdThread serverSocketdThread;

    @Test
    void time()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//大小写皆有意义，不可改动
        Timestamp time = new Timestamp(System.currentTimeMillis());//获取当前系统的时间

        String str = df.format(time);//timestamp转string
        System.out.println(str); //按设置的格式输出年月日时分秒
        System.out.println(time);//按函数库里原本的格式输出年月日时分秒

        //自行任意设置时间戳
        Timestamp a = Timestamp.valueOf("2018-05-23 10:54:44");
        Timestamp b = Timestamp.valueOf("2018-05-22 13:50:30");

        //时间戳之间相减并打出来
        long c = a.getTime()-b.getTime();//得到差值，且差值默认为"微秒"形式
        float d = c;//若不转float，将致差值不带小数
        System.out.println("---");
        System.out.println(d);//输出差值
        System.out.println("------");//输出差值
        float longs = d / (1000*60*60);//"微秒"->"小时"
        System.out.println(longs);
        System.out.println("----");
        //设置显示数字的小数有效位
        DecimalFormat decimalFormat = new DecimalFormat("#.00");//保留2位小数
        String longss = decimalFormat.format(longs);
        System.out.println("时间"+longss);//输出保留2位小数的差值(小时为单位)

        //timestamp->string->timestamp->打印至consloe
        String time2 = df.format(time);
        Timestamp ts = Timestamp.valueOf(time2);
        System.out.println(ts);
    }
    @Test
    void socket() throws InterruptedException {

        serverSocketdThread.start();
        Thread.sleep(123232322);
    }
//    @Test
//    void insert(){
//        locks.setLockId("635");
//        locksMapper.insert(locks);
//    }


}
