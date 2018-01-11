package core.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.test.aop.beans.Sensor;

public class runMain {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("springBeans.xml");
		Sensor sensor=(Sensor) ac.getBean("helloBean");
		System.out.println(sensor.getName());
	}
}
