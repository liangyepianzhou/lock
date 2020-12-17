package com.example.demo.service.socket;

import com.example.demo.mapper.LocksMapper;
import com.example.demo.pojo.Locks;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.Socket;

/**
 * 服务器端处理来自硬件的请求的线程
 * 接收来自硬件的数据并保存
 *
 * 1.警告通知  0
 * 1.1密码输入次数过多1
 * 1.2电量不足2
 *json字符串
 * 格式
 * {lock_id:22,password:220,ip:10.23.23.656,advice:1}
 * j
 */
public class DealSocketData extends Thread {
    Socket socket;
    LocksMapper locksMapper;
    public DealSocketData(Socket socket,LocksMapper locksMapper) {
     this.socket=socket;
     this.locksMapper=locksMapper;
    }

    Locks locks=new Locks();
    @Override
    public void run() {
        try {
            System.out.println("开始处理数据");
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
            String receive="";
                {
                    //注册
                    receive =bufferedReader.readLine();
                    receive=receive.substring(1,receive.length()-1);
//                    System.out.println(receive);
                    String []vlaue =  receive.split(",");
                    String [][]insert=new String[4][2];
                    for (int i = 0; i <vlaue.length ; i++) {
//                        System.out.println(vlaue[i]);
                        insert[i]=vlaue[i].split(":");
//                        for (int j = 0; j <2 ; j++) {
//                            System.out.println(insert[i][j]);
//                        }
                    }
                    locks.setLockId(insert[0][1]);
                    locks.setPassword(insert[1][1]);
                    locks.setIp(insert[2][1]);
                    locks.setAdvice(Integer.valueOf(insert[3][1]));
                    locks.setMumber(0);
                    System.out.println(locks.toString());

                }

            bufferedWriter.write("isOK");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("数据处理完成");
            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        locksMapper.insert(locks);

    }
}
