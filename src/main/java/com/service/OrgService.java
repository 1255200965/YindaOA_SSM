package com.service;

import java.util.List;

import com.model.YoRoleModule;
import com.model.YoUserRole;

public interface OrgService {
    /**
     * 获取所有用户角色信息
     * @return
     */
	List <YoUserRole> getAllUserRole();
	
	/**
	 * 获取所有角色模块信息
	 * @return
	 */
	List<YoRoleModule> getAllRoleModule();
	
	
	
}
