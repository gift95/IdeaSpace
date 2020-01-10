package cn.yunhe.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 守护线程
 * 一个线程作为守护线程，守护另一个线程
 * 执行线程存在，则守护线程一定存在
 * <p>
 * sleep和wait两者的区别
 * sleep在等待过程中仍然持有锁
 * wait在等待过程中会释放锁，需要使用notify或notifyAll来唤醒
 * <p>
 * 生命周期
 * 初始化状态
 * 就绪状态
 * 运行状态
 * 阻塞状态
 * 销毁状态
 * <p>
 * 当任务数多于线程数时，怎么处理？
 * 线程池，对线程进行管理
 */
public class ThreadDemo {

    public static void main(String[] args) {
		/*SubThread st1 = new SubThread();
		SubThread st2 = new SubThread();
		st1.setName("窗口A");
		st2.setName("窗口B");
		
		//设置线程优先级 --默认优先级为5
		st1.setPriority(10);
		st2.setPriority(1);
		
		st1.start();
		st2.start();*/

        SubThread st1 = new SubThread();
        Thread t1 = new Thread(st1, "窗口A");
        Thread t2 = new Thread(st1, "窗口B");
        t1.start();
        t2.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--" + i);
                if (i == 5) {
//					t1.join();
//					t1.yield();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ExecutorService exService = Executors.newFixedThreadPool(4);
        exService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
