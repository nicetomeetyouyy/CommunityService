package com.fy.controller;

import com.fy.entity.Repair;
import com.fy.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    @RequestMapping("findRepairByPage")
    public Map<String,Object> findRepairByPage(String page, String pageSize){
        int total=repairService.getRepairNumber();
        Map<String,Object> map=new HashMap<>();
        map.put("total",total);
        int p=Integer.valueOf(page);
        int limit=Integer.valueOf(pageSize);
        int nowPage= limit<total?p:1;
        int offset=(nowPage-1)*limit;
        map.put("data", repairService.findRepairByPage(limit,offset));
        return map;
    }

    @RequestMapping("addRepair")
    public Map<String,Object> addRepair(@RequestBody Repair repair){
        Map<String,Object> map=new HashMap<>();
        try {
            repairService.insertRepair(repair);
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
    @RequestMapping("delete")
    public Map<String,Object> deleteRepair(@RequestBody Repair repair){
        int id= repair.getId();
        Map<String,Object> map=new HashMap<>();
        try {
            repairService.deleteRepair(id);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","删除成功");
        return map;
    }
    @RequestMapping("setState")
    public Map<String,Object> setState(@RequestBody Repair repair){
        int id= repair.getId();
        int state=repair.getState();
        Map<String,Object> map=new HashMap<>();
        try{
            repairService.updateState(state,id);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","修改成功");
        return map;
    }
    @RequestMapping("findByUserId")
    public List<Repair> findByUserId(String user_id){
        List<Repair> repairs=new ArrayList<>();
        try {
            repairs=repairService.findRepairByUserId(Integer.valueOf(user_id));
        }catch (Exception e){
            return null;
        }
        return repairs;
    }
    @RequestMapping("untreatedRepair")
    public List<Repair> untreatedAdvice(){
        List<Repair> repairs=new ArrayList<>();
        try {
            repairs= repairService.untreatedRepair();
        }
        catch (Exception e){
            return null;
        }
        return repairs;
    }
}
