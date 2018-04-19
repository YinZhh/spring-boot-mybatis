package com.example.boot.dao;

import com.example.boot.domain.IInventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description That's the purpose of the class Young sheldon kill
 * @Author yin.zhh
 * @Date 2018/2/22 16:57
 * @Version v.1.0.0
 */
@Mapper
public interface IInventoryMapper {

    ConcurrentHashMap map = new ConcurrentHashMap();

    int deleteByPrimaryKey(String guid);

    int insert(IInventory record);

    int insertSelective(IInventory record);

    //@Select("SELECT * FROM t_export_inventory WHERE guid = #{guid}")
    IInventory selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(IInventory record);

    int updateByPrimaryKey(IInventory record);
}