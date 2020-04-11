package com.fy.controller;

import com.fy.entity.House;
import com.fy.entity.OwnerBill;
import com.fy.ogm.OwnerRepository;
import com.fy.service.OwnerBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ownerBill")
public class OwnerBillController {
    @Autowired
    private OwnerBillService ownerBillService;
    @Autowired
    private OwnerRepository ownerRepository;

    @RequestMapping("findByOwner")
    public List<OwnerBill> findByOwner(int owner_id) {
        List<OwnerBill> ownerBills = new ArrayList<>();
        try {
            ownerBills = ownerBillService.findByOwner(owner_id);
        } catch (Exception e) {
            return null;
        }
        return ownerBills;
    }

    @RequestMapping("getAllByPage")
    public Map<String, Object> getAllByPage(String page, String pageSize) {

        int total = ownerBillService.getOwnerBillNumber();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        int p = Integer.valueOf(page);
        int limit = Integer.valueOf(pageSize);
        int nowPage = limit < total ? p : 1;
        int offset = (nowPage - 1) * limit;
        map.put("data", ownerBillService.getOwnerBillByPage(limit, offset));
        return map;
    }

    @RequestMapping("addOwnerBill")
    public Map<String, Object> addOwnerBill(Long owner_id, String price, String other, String other_cost) {
        Map<String, Object> map = new HashMap<>();

        DecimalFormat df = new DecimalFormat("#.00");

        List<House> houses = ownerRepository.findHouse(owner_id);
        OwnerBill ownerBill = new OwnerBill();
        ownerBill.setOwner_id(owner_id);
        ownerBill.setOther(other);
        ownerBill.setOther_cost(other_cost);
        if (houses != null) {
            for (House h : houses
            ) {
                ownerBill.setState(-1);
                ownerBill.setAddress(h.getAddress());
                String area = h.getArea();
                Double c = Double.valueOf(area) * Double.valueOf(price);
                Double t = c + Double.valueOf(other_cost);
                String cost = df.format(c);
                String total = df.format(t);
                System.out.println(cost + "  " + total);
                ownerBill.setArea(area);
                ownerBill.setCost(cost);
                ownerBill.setTotal(String.valueOf(total));
                ownerBillService.insertOwnerBill(ownerBill);
            }
            map.put("code", "0");
            map.put("msg", "添加成功");
        } else {
            map.put("code", "-1");
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping("delete")
    public Map<String, Object> deleteOwnerBill(OwnerBill ownerBill) {
        int id = ownerBill.getId();
        Map<String, Object> map = new HashMap<>();
        try {
            ownerBillService.deleteOwnerBill(id);
        } catch (Exception e) {
            map.put("code", "-1");
            map.put("msg", "删除失败");
            return map;
        }
        map.put("code", "0");
        map.put("msg", "删除成功");
        return map;
    }

    @RequestMapping("updateState")
    public Map<String, Object> updateState(int state, int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            ownerBillService.updateState(state, id);
        } catch (Exception e) {
            map.put("code", "-1");
            map.put("msg", "修改失败");
            return map;
        }
        map.put("code", "0");
        map.put("msg", "修改成功");
        return map;
    }
}
