package com.example.demo.Controllor;

import com.example.demo.Util.Resultbean;
import com.example.demo.pojo.Temppasw;
import com.example.demo.pojo.TemppaswExample;
import com.example.demo.service.Temppaswservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/tm")
@ResponseBody
public class TempassController {
    @Autowired
    Temppaswservice temppaswservice;
    /**
     *  查询临时密钥 存在与否
     *  如果不存在则返回前端页面
     *  如果存在，则和硬件进行交互，使其开锁
     */
    private  static int id =1;
    private  static int ids =1;

    @RequestMapping(value = "/open")
    public Resultbean openbytempassw(int lock_id,String password){
        List<Temppasw> list=temppaswservice.quiryforlist(lock_id);
        Map<String,Object> map= new HashMap<>();
        for (Temppasw t : list) {
            if(t.getPassword().equals(password)){
//                如果成功返回的bean中带的map中flag的值为true
                map.put("flag", "true");

                /**
                 * 此处应该有一个和硬件交互开锁临时密钥的独立代码块被调用
                 */
                return Resultbean.success(map);
            }
        }
        map.put("flag","flase");
        return  Resultbean.success(map);
    }
    /**
     * 添加临时密钥
     *
     */
    @RequestMapping(value = "/insert")
    public Resultbean insert(int lock_id, String password, Date date){
        Temppasw temppasw =new Temppasw();
        temppasw.setLockId(lock_id);
        temppasw.setTime(date);
        temppasw.setPassword(password);
        temppasw.setId(id);
        temppasw.setIds(ids);
        id++;
        temppaswservice.add(temppasw);
        /**
         * 此处在返回前应该向锁中写入密钥
         */
        return Resultbean.success();
    }
    @RequestMapping(value = "/delete")
    public Resultbean delete(int id,int lock_id){
       temppaswservice.delete(lock_id,id);
        /**
         * 返回前删除锁中的密钥
         */
       return Resultbean.success();
    }



}
