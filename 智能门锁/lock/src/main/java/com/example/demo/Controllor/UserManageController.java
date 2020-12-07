package com.example.demo.Controllor;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.Util.*;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/sms")
public class UserManageController {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    Users users;
    /**
     * 发送短信
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
        map.put("verifyCode",code);
        map.put("phone",phone);
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
        }
        return map;
    }

    /**
     * 用户登陆
     * @param id
     * @param password
     * @param phone
     * @param code
     * @return
     */
//    晕头了吧，这个登录接口是这么写的吗？  当个占位符吧
    @ResponseBody
    @RequestMapping(value = "/login")
    public Resultbean login(int id,String password,int phone,String code){
       Users users= usersMapper.selectByPrimaryKey(id);
       Map<String,Object> map =new HashMap();
       if(users.getPassword()==password&&users.getCode()==code){
        map.put("flag","true");
       return  Resultbean.success(map);
       }
       else{
           map.put("flag","false");
           return Resultbean.success(map);
       }
    }





}

