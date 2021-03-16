package com.example.demo.socket;

import com.example.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PanServerSocket extends  Thread{
    public PanServerSocket(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    UsersMapper usersMapper;
    @Override
    public void run() {
        ServerSocket serverSocket ;
        Socket socket;
        try {
            serverSocket =new ServerSocket(7788);
            System.out.println("服务器启动");
            while(true){
               socket= serverSocket.accept();
               new DealThread(socket,usersMapper).start();
                System.out.println("服务器接收到请求并开始处理");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
