package cyd.admin.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cyd.admin.sys.entity.SysUser;
import cyd.admin.sys.entity.SystemUser;
import cyd.admin.sys.repository.SystemUserRepository;

/**
 * 
 * @author chenyd
 * 2017年10月12日
 */
@Service
public class SysServiceImpl implements SysService{
	
	@Autowired
	private SystemUserRepository systemUserRepository;

	public List<SysUser> list(SysUser sysuser) {
		return null;
	}


	@Override
	public void UserAdd(SystemUser user) {
		systemUserRepository.save(user);
	}

	@Override
	public void getAllUser(SystemUser user) {
		systemUserRepository.findAll();
	}
}
