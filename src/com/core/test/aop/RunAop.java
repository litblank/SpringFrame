package core.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunAop {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("springBeans.xml");
		UserController user=(UserController) ac.getBean("user");
		user.login();
	}
}
