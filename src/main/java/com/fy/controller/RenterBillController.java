package com.fy.controller;

import com.fy.dao.RenterBillDao;
import com.fy.entity.House;
import com.fy.entity.RenterBill;
import com.fy.service.RenterBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RenterBillController {
  @Autowired
    private RenterBillService renterBillService;
   @RequestMapping("renter_bill/getRenterBillByRenter_id")
   public List<RenterBill> findRenterBillByRenter_id(String renter_id){
       List<RenterBill> renterBills=new ArrayList<>();
       try {
           renterBills=renterBillService.findRenterBillByRenter_id(Integer.valueOf(renter_id));
       }catch (Exception e){
           return null;
       }
       return renterBills;
   }
@RequestMapping("renter_bill/getAllByPage")
   public Map<String,Object> findAllByPage(String page,String pageSize){

       int total=renterBillService.getRenter_billNumber();
       Map<String,Object> map=new HashMap<>();
       map.put("total",total);
       int p=Integer.valueOf(page);
       int limit=Integer.valueOf(pageSize);
       int nowPage= limit<total?p:1;
       int offset=(nowPage-1)*limit;
       map.put("data",renterBillService.getBillNumberByPage(limit,offset));
       return map;
   }
   @RequestMapping("renter_bill/addRenterBill")
    public Map<String,Object> addRenterBill(@RequestBody RenterBill renterBill){
        Map<String,Object> map=new HashMap<>();
        renterBill.setState(-1);
        try {
            renterBillService.insertRenterBill(renterBill);
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
    @RequestMapping("renter_bill/delete")
    public Map<String,Object> deleteRenterBill(@RequestBody RenterBill renterBill){
        int id=renterBill.getId();
        Map<String,Object> map=new HashMap<>();
        try {
            renterBillService.deleteRenterBill(id);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping("renter_bill/getRenterBillByOwner_id")
    public List<RenterBill> findRenterBillByOwner_id(String owner_id){
        List<RenterBill> renterBills=new ArrayList<>();
        try {
            renterBills=renterBillService.findRenterBillByOwner_id(Integer.valueOf(owner_id));
        }catch (Exception e){
            return null;
        }
        return renterBills;
    }
    @RequestMapping("renter_bill/updateState")
    public Map<String, Object> updateState(int state, int id) {
        Map<String, Object> map = new HashMap<>();
        try {
           renterBillService.updateRenterBill(state,id);
        } catch (Exception e) {
            map.put("code", "-1");
            map.put("msg", "删除失败");
            return map;
        }
        map.put("code", "0");
        map.put("msg", "删除成功");
        return map;
    }
}
