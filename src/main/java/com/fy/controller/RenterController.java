package com.fy.controller;

import com.fy.entity.House;
import com.fy.entity.Owner;
import com.fy.entity.Park;
import com.fy.entity.Renter;
import com.fy.ogm.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("renter")
public class RenterController {
    @Autowired
    private RenterRepository renterRepository;

    @RequestMapping("addRenter")
    public Map<String, Object> addRepair(@RequestBody Renter renter) {
        Map<String, Object> map = new HashMap<>();
        try {
            renterRepository.save(renter);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "添加失败");
            return map;
        }
        map.put("code", "0");
        map.put("msg", "添加成功");
        return map;
    }

    @RequestMapping("getAllByPage")
    public Page<Renter> getAllByPage(String page, String pageSize) {
        int p = Integer.valueOf(page) - 1;
        int s = Integer.valueOf(pageSize);
        PageRequest pageRequest = PageRequest.of(p, s);
        Page<Renter> renters;

        try {
            return renterRepository.findAll(pageRequest);
        } catch (Exception e) {
            return null;
        }

    }

    @RequestMapping("delete")
    public Map<String, Object> deleteRenter(@RequestBody Renter renter) {
        Long id=renter.getId();
        Map<String, Object> map = new HashMap<>();
        try {
            renterRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "删除失败");
            return map;
        }
        map.put("code", "0");
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("updateRenter")
    public Map<String, Object> updateRenter(@RequestBody Renter renter) {
        Long id = renter.getId();
        String name=renter.getName();
        String sex=renter.getSex();
        String age=renter.getAge();
        String tel=renter.getTel();
        String identity=renter.getIdentity();
        String user_id=renter.getUser_id();
        String check_in=renter.getCheck_in();
        Map<String, Object> map = new HashMap<>();
        Renter renter1 = renterRepository.updateRenter(id, name, sex, age, tel, identity, user_id,check_in);
        if (renter1 == null) {
            map.put("code", "-1");
            map.put("msg", "修改失败");
            return map;
        } else {
            map.put("code", "0");
            map.put("msg", "修改成功");
            return map;
        }
    }

    @RequestMapping("findByName")
    public List<Renter> findByName(String name) {
        List<Renter> renters = renterRepository.findByNameContaining(name);
        if (renters != null) {
            return renters;
        } else return null;
    }

    @RequestMapping("findByUser_id")
    public Renter findRenterByUser_id(String user_id) {
        Renter renter = renterRepository.findByUser_id(user_id);
        if (renter != null) {
            return renter;
        } else return null;
    }

    @RequestMapping("relatedHouse")
    public Map<String,Object> relatedHouse(Long renter_id,Long house_id) {
        Map<String,Object> map=new HashMap<>();
        try {
            renterRepository.relatedHouse(renter_id,house_id);
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
    @RequestMapping("relatedPark")
    public Map<String,Object> relatedPark(Long renter_id,Long park_id) {
        Map<String,Object> map=new HashMap<>();
        try {
            renterRepository.relatedPark(renter_id,park_id);
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

    @RequestMapping("findRelation")
    public Map<String,Object> findRelation(Long renter_id){
        List<House> houses=renterRepository.findHouse(renter_id);
        List<Park>  parks=renterRepository.findPark(renter_id);
        List<Owner> owners=renterRepository.findOwner(renter_id);
        Map<String,Object> map=new HashMap<>();
        map.put("houses",houses);
        map.put("parks",parks);
        map.put("owner",owners);
        return map;
    }


}

