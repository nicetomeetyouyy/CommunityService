package com.fy.controller;

import com.fy.entity.Park;
import com.fy.ogm.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("park")
public class ParkController {
    @Autowired
    private ParkRepository parkRepository;
    @RequestMapping("addPark")
    public Map<String,Object> addRepair(Park park) {
        Map<String,Object> map=new HashMap<>();
        try {
            parkRepository.save(park);
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
    @RequestMapping("getAllByPage")
    public Page<Park> getAllByPage(String page, String pageSize){
        int p=Integer.valueOf(page)-1;
        int s=Integer.valueOf(pageSize);
        PageRequest pageRequest=PageRequest.of(p,s);
        Page<Park> parks=parkRepository.findAll(pageRequest);
        if(parks!=null){
            return parks;
        }else return null;

    }


    @RequestMapping("delete")
    public Map<String,Object> deleteHouse(Park park) {
        Long id=park.getId();
        Map<String,Object> map=new HashMap<>();
        try {
            parkRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping("findParkByLocation")
    public List<Park> findParkByLocation(String location){
        List<Park> houses =parkRepository.findParkByLocationContaining(location);
        if(houses!=null){
            return houses;
        }else return null;
    }

    @RequestMapping("updatePark")
    public Map<String,Object> updatePark(Park park){
        Long id=park.getId();
        String location=park.getLocation();
        String state=park.getState();
        String sale_time=park.getSale_time();
        String expired_time=park.getExpired_time();
        Map<String,Object> map=new HashMap<>();
        Park park1=parkRepository.updatePark(id,location,state,sale_time,expired_time);
        if(park1==null){
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }else {
            map.put("code","0");
            map.put("msg","修改成功");
            return map;
        }
    }
}
