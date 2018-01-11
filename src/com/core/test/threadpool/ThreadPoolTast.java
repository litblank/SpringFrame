package core.test.threadpool;

import java.io.Serializable;

public class ThreadPoolTast implements Runnable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object attachData;
	
	public ThreadPoolTast(Object tasks) {
		this.attachData=tasks;
	}

	@Override
	public void run() {
		
		try {
			System.out.println("开始执行任务："+attachData+"任务，使用线程池，线程名称："+Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		attachData=null;
		
	}
}
