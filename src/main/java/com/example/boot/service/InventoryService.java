package com.example.boot.service;

import com.example.boot.domain.IInventory;

/**
 * @ClassName InventoryService
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-02-22 16:51
 * @Version v.1.0.0
 */
public interface InventoryService {

    /**
     * @Description (That's the purpose of the method)
     * @Date 2018/2/22 17:05
     * @Param guid
     * @Return IInventory
     * @Throws
     */
    IInventory selectPrimaryKey(String guid);

    IInventory updateByPrimaryKey(String guid);
}
