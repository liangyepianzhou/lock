package com.example.demo.service.socket;

import com.example.demo.mapper.LocksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
@Component
public class ServerSocketdThread extends Thread{
    @Autowired
    LocksMapper locksMapper;
    @Override
    public void run() {
        //设置一个服务器套接字 监听来在客户端的请求
        ServerSocket listen = null;
        try {
            listen = new ServerSocket(5656);
            System.out.println("服务器套接字启动");
            while(true){
                Socket socket=listen.accept();
                System.out.println("接收到请求");
                new DealSocketData(socket,locksMapper).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
