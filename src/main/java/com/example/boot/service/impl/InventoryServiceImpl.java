package com.example.boot.service.impl;

import com.example.boot.dao.IInventoryMapper;
import com.example.boot.domain.IInventory;
import com.example.boot.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName InventoryServiceImpl
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-02-22 16:52
 * @Version v.1.0.0
 */

@Service
public class InventoryServiceImpl implements InventoryService {

    private Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Autowired
    private IInventoryMapper iInventoryMapper;

    @Override
    public IInventory selectPrimaryKey(String guid) {
        return iInventoryMapper.selectByPrimaryKey(guid);
    }

    @Override
    public IInventory updateByPrimaryKey(String guid) {
        IInventory iInventory = this.selectPrimaryKey(guid);
        iInventory.setCustomsCode("9999");
        logger.info("====================>>" + guid);
        iInventoryMapper.updateByPrimaryKey(iInventory);

        return iInventory;
    }
}
