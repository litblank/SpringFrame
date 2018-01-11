package cyd.admin.sys.controller;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import core.base.BaseController;
import core.utils.BeanUtil;
import core.utils.PageInfo;
import cyd.admin.sys.entity.SysUser;
import cyd.admin.sys.entity.SystemUser;
import cyd.admin.sys.service.SysServiceImpl;

/**
 * 
 * @author chenyd
 * 2017年10月12日
 */
@Controller
@RequestMapping("/sys")
public class SysController extends BaseController{
	
	private static final Logger LOGGER = LogManager.getLogger(SysController.class);
	
	@Autowired
	private SysServiceImpl sysService;
	
	@GetMapping("/login")
	@ResponseBody
	public Object login(SysUser sysuser){
		//System.out.println(AdminController.class);
		PageHelper.startPage(1, 10);
		List<SysUser>  userlist=sysService.list(sysuser);
		PageInfo<SysUser> pageInfo =BeanUtil.toPageInfo(userlist);
		return renderSuccess(pageInfo);
	}
	
	@GetMapping("/saveUserAdd")
	@ResponseBody
	public Object addSystemUser(SystemUser user){
		System.out.println(sysService);
		sysService.UserAdd(user);
		return renderSuccess(user);
	}
	
	@GetMapping("/getAllUser")
	@ResponseBody
	public Object getSystemUser(SystemUser user){
		sysService.getAllUser(user);
		return renderSuccess(user);
	}
	
}
