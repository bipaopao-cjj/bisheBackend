package com.ape.apesystem.service;

import com.ape.apesystem.domain.ApeMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 
 * @version 1.0
 * @description: 菜单service
 * 
 */
public interface ApeMenuService extends IService<ApeMenu> {

    /**
    * @description: 根据用户获取菜单权限
    * @param: id
    * @return:
    * 
    * 
    */
    List<ApeMenu> getMenuByUser(String id);

}
