package com.example.demo.service.socket.testsocket;

import java.io.*;
import java.net.Socket;

public class Testsocket1 {

    public static void main(String[] args) throws Exception {
        System.out.println("尝试启动客户端服务器");
        Socket socket=new Socket("10.17.164.156",5656);
        System.out.println("客户端服务器启动完成");
        OutputStream outputStream =socket.getOutputStream();
        InputStream inputStream=socket.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(1);
        bufferedWriter.flush();
        String message="{lock_id:13,passwpord:12,ip:12.12.12.12,advice:00}";
        System.out.println(message);
//        byte b[]="{lock_id:13,passwpord:12,ip:12.12.12.12}".getBytes();
//        System.out.println(b);
//        outputStream.write(b);
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        while (!bufferedReader.readLine().equals("isOK")){;}

//        System.out.println("客户端关闭");
    }

}
