package cyd.admin.sys.dao;

import java.util.List;

import cyd.admin.sys.entity.SysUser;
/**
 * 
 * @author chenyd
 * 2017年10月12日
 */
public interface AdminMapper {
	
	List<SysUser> list(SysUser sysuser);
}
