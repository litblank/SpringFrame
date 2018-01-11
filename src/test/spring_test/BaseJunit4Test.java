package spring_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cyd.admin.sys.controller.SysController;
import cyd.admin.sys.entity.SystemUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-config.xml" })
public class BaseJunit4Test {
	
	@Autowired
	private SysController sysController;
	
	@Test
	public void run(){
		SystemUser user=new SystemUser();
		user.setUserName("cyd");
		sysController.addSystemUser(user);
	}
}

