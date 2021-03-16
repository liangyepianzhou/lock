package com.example.demo.socket;

import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Users;
import com.example.demo.pojo.UsersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;

import javax.print.DocFlavor;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class DealThread extends Thread {
    private Socket client=null;
    Users users=new Users();
    private UsersMapper usersMapper ;
    public  UsersExample usersExample=new UsersExample();
    private boolean load =false;
    public DealThread(Socket client, UsersMapper usersMapper) {
        System.out.println("处理线程创建");
        this.client = client;
        this.usersMapper = usersMapper;
    }

    @Override
    public void run() {
        try {

            System.out.println("进入处理线程");
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            int flag =bufferedReader.read();
            System.out.println(flag);
            while(true){
             switch (flag){
                     //登陆功能
                     case 1:
                     {

                         String username =bufferedReader.readLine();
                         String password =bufferedReader.readLine();
                         System.out.println("username:"+username);
                         System.out.println("password:"+password);
                         users.setUsername(username);
                         users.setPassword(password);
                         usersExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
                         List<Users> list=usersMapper.selectByExample(usersExample);
                        if(list.size()==0){

                            bufferedWriter.write(0);
                            bufferedWriter.flush();
                        }
                        else{
                            bufferedWriter.write(1);
                            bufferedWriter.flush();
                            load=true;
                        }
                         break;

                     }
                     //注册功能
                     case 2:
                     {
                         users.setUsername(bufferedReader.readLine());
                         users.setPassword(bufferedReader.readLine());
                         usersMapper.insert(users);
                         bufferedWriter.write(1);
                         bufferedWriter.flush();
                         break;
                     }
                     //查看所有文件
                     case 3:
                     {
                         if(!load){break;}


                         break;

                     }
                     //上传功能
                     case 4:
                     {
                         if(!load){
                             bufferedWriter.write(0);
                             bufferedWriter.flush();
                             break;}
                         else{
                             bufferedWriter.write(1);
                             bufferedWriter.flush();
                         }
                         String contextName =bufferedReader.readLine();
                         System.out.println("contextName:"+contextName);
                          String received = bufferedReader.readLine();
                         System.out.println("receive:"+received);
                         //文件存放到服务器本地，并实现分区存放。
                         FileOutputStream fileOutputStream =new FileOutputStream("C:\\Users\\DELL\\Desktop\\商城项目\\pan2\\"+users.getUsername()+"\\"+contextName);
                         fileOutputStream.write(received.getBytes());
                         users.setDatabaseurl(contextName);
                         usersMapper.updateByExample(users,usersExample);
                         break;

                     }
                     //下载功能
                     case 5:
                     {
                         if(!load){
                             bufferedWriter.write(0);
                             bufferedWriter.flush();
                             break;}

                         break;

                     }
             }

            if(bufferedReader.read()==1){break;}
            else{
                flag =bufferedReader.read();
                System.out.println(flag);
            }
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
