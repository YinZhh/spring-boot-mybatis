package com.example.boot.controller;

import com.example.boot.domain.IInventory;
import com.example.boot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @ClassName InventoryContorller
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-02-22 16:50
 * @Version v.1.0.0
 */
@RestController
@EnableAutoConfiguration
public class InventoryContorller {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryContorller(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @RequestMapping(value = "/invt.json", method = RequestMethod.GET)
    @ResponseBody
    public IInventory selectIInventory(@RequestParam(value = "guid", required = false) String guid) {
        return inventoryService.selectPrimaryKey(guid);
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
