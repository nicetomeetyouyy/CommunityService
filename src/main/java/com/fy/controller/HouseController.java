package com.fy.controller;

import com.fy.entity.House;
import com.fy.ogm.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("house")
public class HouseController {
     @Autowired
    private HouseRepository houseRepository;

}
