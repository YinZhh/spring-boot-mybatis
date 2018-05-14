package com.example.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.domain.IInventory;
import com.example.boot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName InventoryContorller
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-02-22 16:50
 * @Version v.1.0.0
 */
@Controller
@EnableAutoConfiguration
public class InventoryContorller {

    private final InventoryService inventoryService;

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public InventoryContorller(InventoryService inventoryService, StringRedisTemplate stringRedisTemplate) {
        this.inventoryService = inventoryService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    //http://172.19.5.203:8080/invt.json?guid=2E5CB85354344F6B9B8BCAA3DF3818C8
    @RequestMapping(value = "/invt.json", method = RequestMethod.GET)
    //@ResponseBody
    public String selectIInventory(@RequestParam(value = "guid", required = false) String guid) {
        if(guid == null || guid.trim().length() == 0) {

            String name = stringRedisTemplate.opsForValue().get("name");
            IInventory i = new IInventory();
            i.setGuid(name);
            return JSONObject.toJSONString(i);
        }
        //stringRedisTemplate.delete("iInventory");
        String iInvent = stringRedisTemplate.opsForValue().get("iInventory");
        if (iInvent == null){
            stringRedisTemplate.opsForValue().append("iInventory" , JSONObject.toJSONString(inventoryService.selectPrimaryKey(guid)));
        }
        //return stringRedisTemplate.opsForValue().get("iInventory");
        //return inventoryService.selectPrimaryKey(guid);
        return "/hello";
    }

    /**
     * @Description (That ' s the purpose of the method)
     * @Date 2018/2/23 17:20
     * @Param [guid]
     * @Return com.example.quartz.domain.IInventory
     * @Throws
     */
    @RequestMapping(value = "/update.json", method = RequestMethod.GET)
    @ResponseBody
    public IInventory updateByPrimaryKey(@RequestParam(value = "guid", required = false) String guid) {
        return inventoryService.updateByPrimaryKey(guid);
    }
}
