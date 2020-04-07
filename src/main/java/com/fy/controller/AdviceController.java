package com.fy.controller;

import com.fy.entity.Advice;
import com.fy.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdviceController {
    @Autowired
    private AdviceService adviceService;
    @RequestMapping("advice/addAdvice")
    public Map<String,Object> addAdvice(Advice advice){
        Map<String,Object> map=new HashMap<>();
        advice.setState(-1);
        try {
            adviceService.insertAdvice(advice);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","添加失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","添加成功");
        return map;
    }

    @RequestMapping("advice/findAdviceByPage")
    public Map<String,Object> findAdviceByPage(String page,String pageSize){
        int total=adviceService.getAdviceNumber();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        int p=Integer.valueOf(page);
        int limit=Integer.valueOf(pageSize);
        int nowPage= limit<total?p:1;
        int offset=(nowPage-1)*limit;
        map.put("data", adviceService.findAdviceByPage(limit,offset));
        return map;
    }
    @RequestMapping("advice/delete")
    public Map<String,Object> deleteAdvice(String id){
        int i= Integer.valueOf(id);
        Map<String,Object> map=new HashMap<>();
        try {
            adviceService.deleteAdvice(i);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","删除成功");
        return map;
    }
    @RequestMapping("advice/findByUserId")
    public List<Advice> findByUserId(String id){
        List<Advice> advices=new ArrayList<>();
        try {
            advices=adviceService.findByUserId(Integer.valueOf(id));
        }catch (Exception e){
            return null;
        }
        return advices;
    }
    @RequestMapping("advice/setAnswer")
    public Map<String,Object> setAnswer(String answer, int id){
        int i= Integer.valueOf(id);
        Map<String,Object> map=new HashMap<>();
        try{
            adviceService.updateAdvice(answer,i);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","修改成功");
        return map;
    }
    @RequestMapping("advice/untreatedAdvice")
    public List<Advice> untreatedAdvice(){
        List<Advice> advice=new ArrayList<>();
        try {
            advice= adviceService.untreatedAdvice();
        }
        catch (Exception e){
            return null;
        }
        return advice;
    }
}
