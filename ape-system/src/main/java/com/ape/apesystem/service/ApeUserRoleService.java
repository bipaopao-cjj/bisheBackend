package com.ape.apesystem.service;

import com.ape.apesystem.domain.ApeUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * 
 * @version 1.0
 * @description: 用户角色关系service
 * 
 */
public interface ApeUserRoleService extends IService<ApeUserRole> {

    /**
    * @description: 根据账号获取角色
    * @param: loginAccount
    * @return:
    * 
    * 
    */
    Set<String> getUserRolesSet(String loginAccount);

}
