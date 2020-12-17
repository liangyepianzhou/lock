package com.example.demo.service.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocketService {

    String ip;
    //构造方法，依据传来的锁的ip地址创建socket
    public ClientSocketService(String ip) {
    this.ip=ip;
    }
    //给硬件发送一段指令
    public void addtemppass(String order) throws IOException {

            Socket socket =new Socket(ip,11);
            OutputStream outputStream= socket.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(order);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
    }

}
