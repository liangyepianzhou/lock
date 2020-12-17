package com.example.demo.Controllor;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.Util.*;
import com.example.demo.mapper.LocksMapper;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Locks;
import com.example.demo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;

@Controller
@RequestMapping("/sms")
public class UserManageController {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    Users users;
    @Autowired
    LocksMapper locksMapper;
    //大小写皆有意义，不可改动

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 用于发送短信
     * 短信发送完，会返回一个map
     * map中有验证码的信息和系统时间
     * 前提交表单的时候讲验证码和系统时间一并返回
     * @param phone
     * @param request
     * @return
     * @throws ClientException
     */
    @RequestMapping(value = "/smsXxs")
    @ResponseBody
    public Map<String,Object> smsXxs(String phone, HttpServletRequest request) throws ClientException {
        Map<String,Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        // 短信模板id
        String TemplateCode = "SMS_206546093";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam,TemplateCode);
        //将验证码code 电话号码  系统时间一并返回
        //获取当前系统的时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        //timestamp转string
        String str = df.format(time);
        map.put("verifyCode",code);
        map.put("phone",phone);
        map.put("sendtime",str);
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
        }
        return map;
    }

    /**
     * 用户登陆
     * 门锁id+门锁密码
     * 手机号+短信验证码
     *
     * 暂缺   防爬虫验证码
     * @param phone
     * @param password
     * @param phone
     * @param code
     * @return boolean
     */

    @ResponseBody
    @RequestMapping(value = "/login")
    public Resultbean login(String phone,String lock_id,String  password,String code,String time){
        Map<String,Object > map=new HashMap<>();
        //验证码发送的时间
        Timestamp get =Timestamp.valueOf(time);
        //当前时间
        Timestamp now =Timestamp.valueOf(df.format(new Date()));
        //获取时间差  时间差单位为微妙但是精度为妙
        long l=now.getTime()-get.getTime();
        l=l/1000;
        if(l>180)
        {
            //验证码超时  180秒
            Locks lock =locksMapper.selectByPrimaryKey(lock_id);
            if(lock!=null){
                if(lock.getPassword().equals(password)){
                    map.put("flag",true);
                }
                else
                {
                    map.put("flag",false);
                    map.put("message","账号或密码错误");
                }

            }
           else{
                map.put("flag",false);
                map.put("message","未找到门锁");
            }
        }
        else
        {
            map.put("flag",false);
            map.put("message","验证码超时");
        }
        return Resultbean.success(map);


    }





}

