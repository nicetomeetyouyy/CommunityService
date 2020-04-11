package com.fy.controller;

import com.fy.entity.House;
import com.fy.entity.Owner;
import com.fy.entity.Renter;
import com.fy.ogm.HouseRepository;
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
@RequestMapping("house")
public class HouseController {
     @Autowired
    private HouseRepository houseRepository;
    @RequestMapping("addHouse")
    public Map<String,Object> addRepair(@RequestBody House house) {
        Map<String,Object> map=new HashMap<>();
        try {
            houseRepository.save(house);
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
    public Page<House> getAllByPage(String page,String pageSize){
        int p=Integer.valueOf(page)-1;
        int s=Integer.valueOf(pageSize);
        PageRequest pageRequest=PageRequest.of(p,s);
        Page<House> houses=houseRepository.findAll(pageRequest);
        if(houses!=null){
            return houses;
        }else return null;

    }
    @RequestMapping("delete")
    public Map<String,Object> deleteHouse(@RequestBody House house) {
        Long id=house.getId();
        Map<String,Object> map=new HashMap<>();
        try {
            houseRepository.deleteById(Long.valueOf(id));
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

    @RequestMapping("updateHouse")
    public Map<String,Object> updateHouse(@RequestBody House house){
        Long id=house.getId();
        String address=house.getAddress();
        String area=house.getArea();
        String type=house.getType();
        String register_time=house.getRegister_time();
        Map<String,Object> map=new HashMap<>();
        House house1=houseRepository.updateHouse(id,address,area,type,register_time);
        if(house1==null){
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }else {
            map.put("code","0");
            map.put("msg","修改成功");
            return map;
        }
    }

    @RequestMapping("findHouseByAddress")
    public List<House> findHouseByName(String address){
        List<House> houses =houseRepository.findByAddressContaining(address);
        if(houses!=null){
            return houses;
        }else return null;
    }

    @RequestMapping("findRelation")
    public Map<String,Object> findRelation(Long house_id){
        List<Renter>  renters=houseRepository.findRenter(house_id);
        List<Owner> owners=houseRepository.findOwner(house_id);
        Map<String,Object> map=new HashMap<>();
        map.put("renter",renters);
        map.put("owner",owners);
        return map;
    }

}
