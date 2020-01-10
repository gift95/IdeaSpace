package cn.yunhe.thread;

/**
 * 进程：一个应用程序的运行
 * 线程：进程中的一个执行单元
 * 关系：一个进程可以有多个线程，一个线程只能属于某一个进程
 * <p>
 * 使用：Thread
 * 创建线程的方式：
 * 方式一：继承Thread类并重写run方法
 * 注意：run()中写的线程要执行的任务
 * start()用于创建并开启一个线程
 * 缺点：在java的普通类中不允许出现多继承，因此如果是继承的形式实现线程，那么该类就无法在继承其它类，扩展性不好
 * 方式二：实现Runnable接口并重写run方法
 * 注意：使用接口的形式之所以能走子类中的run方法是因为使用的Thread的构造器中传递了一个runnable对象
 * 多线程中为什么需要使用锁？
 * 当一个线程在运算的过程中，另一个线程也参与了，就会出现安全问题
 * 锁的使用--Synchronized
 * 语法：Synchronized(锁){公共的代码}
 * 锁 指的是唯一的对象
 * 死锁的产生
 * 产生了资源互斥
 * 单例模式
 * 单例模式中多线程的面试题
 * 垃圾回收机制
 * 线程的声明周期
 * Timer定时器
 * Vol
 */
public class NewCachedThreadTest {

    public static void main(String[] args) {
        //方式一
		/*SubThread st = new SubThread();
		st.start();*/

        //方式二
		/*SubThread st = new SubThread();
		//想要创建并开启一个线程就需要使用Thread类中的start()
		Thread thread = new Thread(st);//new Thread(Runnable target) Runnable target = new SubThread();
		thread.start();*/

        //线程名称
		/*Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket,"窗口A");
		Thread t2 = new Thread(ticket,"窗口B");
		t1.start();
		t2.start();*/

        //睡眠
		/*Ticket ticket1 = new Ticket();
		Ticket ticket2 = new Ticket();
		
		Thread t1 = new Thread(ticket1,"窗口A");
		Thread t2 = new Thread(ticket2,"窗口B");
		t1.start();
		t2.start();*/

        //锁 代码块上的锁
		/*SyncTicket ticket1 = new SyncTicket();
		SyncTicket ticket2 = new SyncTicket();
		
		Thread t1 = new Thread(ticket1,"窗口A");
		Thread t2 = new Thread(ticket2,"窗口B");
		t1.start();
		t2.start();*/

        //方法上的锁
        SyncTicket ticket = new SyncTicket();

        Thread t1 = new Thread(ticket, "窗口A");
        Thread t2 = new Thread(ticket, "窗口B");
        t1.start();
        t2.start();

    }
}
