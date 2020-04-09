package com.fy.controller;

import com.fy.entity.House;
import com.fy.entity.Owner;
import com.fy.entity.Park;
import com.fy.entity.Renter;
import com.fy.ogm.OwnerRepository;
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
@RequestMapping("owner")
public class OwnerController  {
    @Autowired
    private OwnerRepository ownerRepository;
    @RequestMapping("addOwner")
    public Map<String,Object> addRepair(@RequestBody Owner owner) {
        Map<String,Object> map=new HashMap<>();
        try {
            ownerRepository.save(owner);
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
    public Page<Owner> getAllByPage(String page,String pageSize){
        int p=Integer.valueOf(page)-1;
        int s=Integer.valueOf(pageSize);
        PageRequest pageRequest=PageRequest.of(p,s);
        Page<Owner> owners;

        try {
            return  ownerRepository.findAll(pageRequest);
        }catch (Exception e){
            return null;
        }

    }
    @RequestMapping("delete")
    public Map<String,Object> deleteOwner(@RequestBody Owner owner) {
        Long id=owner.getId();
        Map<String,Object> map=new HashMap<>();
        try {
            ownerRepository.deleteById(Long.valueOf(id));
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
      @RequestMapping("updateOwner")
    public Map<String,Object> updateOwner(@RequestBody Owner owner){
        Long id=owner.getId();
        String name=owner.getName();
        String sex=owner.getSex();
        String age=owner.getAge();
        String tel=owner.getTel();
        String identity =owner.getIdentity();
        String user_id=owner.getUser_id();
          Map<String,Object> map=new HashMap<>();
        Owner owner1=ownerRepository.updateOwner(id,name, sex,  age, tel, identity, user_id);
        if(owner1==null){
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }else {
            map.put("code","0");
            map.put("msg","修改成功");
            return map;
        }
    }
    @RequestMapping("findOwnerByName")
    public List<Owner> findOwnerByName(String name){
        List<Owner> owners =ownerRepository.findByNameContaining(name);
        if(owners!=null){
            return owners;
        }else return null;
    }

    @RequestMapping("findByUser_id")
    public Owner findOwnerByUser_id(String user_id){
        Owner owner =ownerRepository.findByUser_id(user_id);
        if(owner!=null){
            return owner;
        }else return null;
    }

    @RequestMapping("relatedRenter")
    public Map<String,Object> relatedRenter(Long owner_id,Long renter_id) {
        Map<String,Object> map=new HashMap<>();
        try {
            ownerRepository.relatedRenter(owner_id,renter_id);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","审核失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","审核成功");
        return map;
    }

    @RequestMapping("relatedHouse")
    public Map<String,Object> relatedHouse(Long owner_id,Long house_id) {
        Map<String,Object> map=new HashMap<>();
        try {
            ownerRepository.relatedHouse(owner_id,house_id);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","审核失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","审核成功");
        return map;
    }

    @RequestMapping("findRenter")
    public List<Renter> findRenter(String user_id){
        List<Renter> renters =ownerRepository.findRenter(user_id);
        System.out.println(user_id);
        if(renters!=null){
            return renters;
        }else return null;
    }

    @RequestMapping("relatedPark")
    public Map<String,Object> relatedPark(Long owner_id,Long park_id) {
        Map<String,Object> map=new HashMap<>();
        try {
            ownerRepository.relatedPark(owner_id,park_id);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","审核失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","审核成功");
        return map;
    }
    @RequestMapping("findRenterHouse")
    public List<House> findRenterHouse(Long owner_id){
        List<House> houses =ownerRepository.findRenterHouse(owner_id);
        if(houses!=null){
            return houses;
        }else return null;
    }
    @RequestMapping("findHouse")
    public List<House> findHouse(Long owner_id){
        List<House> houses =ownerRepository.findHouse(owner_id);
        if(houses!=null){
            return houses;
        }else return null;
    }

    @RequestMapping("findRenterPark")
    public List<Park> findRenterPark(Long owner_id){
        List<Park> parks =ownerRepository.findRenterPark(owner_id);
        if(parks!=null){
            return parks;
        }else return null;
    }
    @RequestMapping("findPark")
    public List<Park> findPark(Long owner_id){
        List<Park>parks =ownerRepository.findPark(owner_id);
        if(parks!=null){
            return parks;
        }else return null;
    }
}
