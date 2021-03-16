package com.example.demo.socket;

import com.example.demo.pojo.Users;
import com.example.demo.pojo.UsersExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) {
        boolean load =false;
        try {
            Socket socket =new Socket("127.0.0.1",7788);
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            byte [] buffer=new byte[1024];
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream;
            Scanner reader=new Scanner(System.in);
            System.out.println("===================");
            System.out.println("欢迎登陆云盘");
            System.out.println("====================");
            System.out.println("登陆:1\n注册:2\n查看所有文件:3\n上传文件:4\n下载文件:5\n");
            int flag =reader.nextInt();
            //读取换行符
            reader.nextLine();
            bufferedWriter.write(flag);
            bufferedWriter.flush();
            while(true){

                switch (flag){
                    //登陆功能
                    case 1:
                    {
                        System.out.println("请输入您的用户名\n");
                        String username =reader.nextLine();
                        System.out.println(username);
                        bufferedWriter.write(username);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        System.out.println("请输入您的密码");
                        String password =reader.nextLine();
                        System.out.println(password);
                        bufferedWriter.write(password);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        if (bufferedReader.read()==1)
                        {
                            load=true;
                            System.out.println("登陆成功\n");
                        }
                        else{
                            System.out.println("登录失败\n");
                        }

                        break;

                    }
                    //注册功能
                    case 2:
                    {
                        System.out.println("请输入您的用户名");
                        bufferedWriter.write(reader.nextLine());
                        bufferedWriter.newLine();
                        System.out.println("请输入您的密码");
                        bufferedWriter.write(reader.nextLine());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        if(bufferedReader.read()==1){
                            System.out.println("注册成功");
                        }
                        else{
                            System.out.println("注册失败");
                        }
                        break;

                    }
                    //查看所有文件
                    case 3:
                    {

                        break;

                    }
                    //上传功能
                    case 4:
                    {
                        if(bufferedReader.read()==0){
                            System.out.println("请先登录");
                            break;
                        }
                        System.out.println("请输入您要上传的文件地址");
                        String inputUrl =reader.nextLine();
                        System.out.println("url："+inputUrl);
                        System.out.println("请输入您的文件名");
                        String contextName=reader.nextLine();
                        System.out.println("context Name:"+contextName);
                        fileInputStream=new FileInputStream(inputUrl);
                        bufferedWriter.write(contextName);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        while(fileInputStream.read(buffer)!=-1)
                        {
                        bufferedWriter.write(new String(buffer));
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        }
                        if(bufferedReader.read()==1){
                            fileInputStream.close();
                            System.out.println("上传成功");
                        }
                        break;

                    }
                    //下载功能
                    case 5:
                    {
                        if(bufferedReader.read()==0){
                            System.out.println("请先登录");
                            break;
                        }

                        break;

                    }
                    default:{}
                }

                System.out.println("继续操作请输入1，结束操作请输入0");
                if(reader.nextInt()==0){
                    bufferedReader.close();
                    bufferedWriter.close();
                    reader.close();
                    break;}
                else
                {
                    System.out.println(reader.nextLine());
                    System.out.println("登陆:1\n注册:2\n查看所有文件:3\n上传文件:4\n下载文件:5\n");
                    flag =reader.nextInt();
                    reader.nextLine();
                    System.out.println(flag);
                    bufferedWriter.write(0);
                    bufferedWriter.write(flag);
                    bufferedWriter.flush();


                }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
