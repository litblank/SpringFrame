package cyd.admin.sys.service;

import java.util.List;

import cyd.admin.sys.entity.SysUser;
import cyd.admin.sys.entity.SystemUser;

/**
 * 
 * @author chenyd
 * 2017年10月12日
 */
public interface SysService {
	
	List<SysUser> list(SysUser sysuser);
	
	void UserAdd(SystemUser user);
	
	void getAllUser(SystemUser user); 
}
