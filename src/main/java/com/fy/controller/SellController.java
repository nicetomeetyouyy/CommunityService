package com.fy.controller;

import com.fy.entity.Sell;
import com.fy.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @RequestMapping("addSell")
    public Map<String,Object> addSell(Sell sell){
        Map<String,Object> map=new HashMap<>();
        try {
            sellService.insertSell(sell);
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
            sellService.deleteSell(id);
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
    public List<Sell> findRenterBillByRenter_id(String froms){
        List<Sell> sells=new ArrayList<>();
        try {
            sells= sellService.findByUser(froms);
        }catch (Exception e){
            return null;
        }
        return sells;
    }


    @RequestMapping("getAllByPage")
    public Map<String, Object> getAllByPage(String page, String pageSize) {

        int total = sellService.getSellNumber();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        int p = Integer.valueOf(page);
        int limit = Integer.valueOf(pageSize);
        int nowPage = limit < total ? p : 1;
        int offset = (nowPage - 1) * limit;
        map.put("data", sellService.getSellByPage(limit,offset));
        return map;
    }
}
