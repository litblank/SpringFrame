package core.test.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 线程池
 * 构造函数参数
 * 
 * 1、corePoolSize 核心线程数大小，当线程数 < corePoolSize ，会创建线程执行 runnable
 * 
 * 2、maximumPoolSize 最大线程数， 当线程数 >= corePoolSize的时候，会把 runnable 放入 workQueue中
 * 
 * 3、keepAliveTime 保持存活时间，当线程数大于corePoolSize的空闲线程能保持的最大时间。
 * 
 * 4、unit 时间单位
 * 
 * 5、workQueue 保存任务的阻塞队列
 * 
 * 6、threadFactory 创建线程的工厂
 * 
 * 7、handler 拒绝策略
 * 
 * 任务执行顺序    （核心线程数，阻塞队列，最大线程数，异常）
 * 
 * 1、当线程数小于 corePoolSize时，创建线程执行任务。
 * 
 * 2、当线程数大于等于 corePoolSize并且 workQueue 没有满时，放入workQueue中
 * 
 * 3、线程数大于等于 corePoolSize并且当 workQueue 满时，新任务新建线程运行，线程总数要小于 maximumPoolSize
 * 
 * 4、当线程总数等于 maximumPoolSize 并且 workQueue 满了的时候执行 handler 的
 * rejectedExecution。也就是拒绝策略。
 * 
 * 四个拒绝策略
 * 
 * ThreadPoolExecutor默认有四个拒绝策略：
 * 
 * 1、ThreadPoolExecutor.AbortPolicy() 直接抛出异常RejectedExecutionException
 * 
 * 2、ThreadPoolExecutor.CallerRunsPolicy() 直接调用run方法并且阻塞执行
 * 
 * 3、ThreadPoolExecutor.DiscardPolicy() 直接丢弃后来的任务
 * 
 * 4、ThreadPoolExecutor.DiscardOldestPolicy() 丢弃在队列中队首的任务
 * 
 * 当然可以自己继承RejectedExecutionHandler来写拒绝策略.
 * 
 * @author chenyd 2017年10月24日
 */
public class TestThreadPoolExecutor {
	public static void main(String[] args) {
		Long currentTimeMillis = System.currentTimeMillis();
		// new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
		// unit, workQueue)
		ThreadPoolExecutor threadpool = new ThreadPoolExecutor(3, 10, 3, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(3));

		for (int i = 0; i < 100; i++) {

			try {
				String task = "task=" + i;
				System.out.println("创建任务并提交到线程池：" + task);
				threadpool.execute(new ThreadPoolTast(task));

				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		try {
			threadpool.shutdown();
			boolean loop = true;

			do {
				loop = !threadpool.awaitTermination(2, TimeUnit.SECONDS);
			} while (loop);

			if (loop != true) {
				System.out.println("所有线程执行完毕");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
		}

	}
}
