package com.fy.controller;

import com.fy.entity.RentList;
import com.fy.service.RentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rentlist")
public class RentListController {
    @Autowired
    private RentListService rentListService;

    @RequestMapping("addRenterList")
    public Map<String,Object> addRenterList(@RequestBody RentList rentList){
        Map<String,Object> map=new HashMap<>();
        try {
            rentListService.insertRentList(rentList);
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
    public Map<String,Object> deleteRentList(int id){
        Map<String,Object> map=new HashMap<>();
        try {
            rentListService.deleteRentList(id);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","删除成功");
        return map;
    }
    @RequestMapping("findByUser")
    public List<RentList> findRenterBillByRenter_id(String froms){
        List<RentList> rentLists=new ArrayList<>();
        try {
           rentLists= rentListService.findByUser(froms);
        }catch (Exception e){
            return null;
        }
        return rentLists;
    }


    @RequestMapping("getAllByPage")
    public Map<String, Object> getAllByPage(String page, String pageSize) {

        int total = rentListService.getRentListNumber();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        int p = Integer.valueOf(page);
        int limit = Integer.valueOf(pageSize);
        int nowPage = limit < total ? p : 1;
        int offset = (nowPage - 1) * limit;
        map.put("data", rentListService.getRentListByPage(limit,offset));
        return map;
    }
}
