package com.fy.controller;

import com.fy.entity.Owner;
import com.fy.ogm.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("owner")
public class OwnerContoller  {
    @Autowired
    private OwnerRepository ownerRepository;
    @RequestMapping("addOwner")
    public Map<String,Object> addRepair(Owner owner) {
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
    public Map<String,Object> deleteOwner(String id) {

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
    public Map<String,Object> updateOwner(String id, String name, String sex, String age, String tel, String identity, String user_id){
        Long i=Long.valueOf(id);
          Map<String,Object> map=new HashMap<>();
        Owner owner1=ownerRepository.updateOwner(i,name, sex,  age, tel, identity, user_id);
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
}
