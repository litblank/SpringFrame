package core.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class log {
	
	public void logStart(){
		System.out.println("logstart...");
	}

	public void logEnd(){
		System.out.println("logend...");
	}
	
	public void around(ProceedingJoinPoint  pjb) throws Throwable{
		System.out.println("start...  aroud...");
		//µ÷ÓÃºËÐÄÂß¼­
		pjb.proceed();
		System.out.println("end...  aroud...");
	}
}
