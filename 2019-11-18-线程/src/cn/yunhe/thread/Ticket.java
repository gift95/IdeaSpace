package cn.yunhe.thread;

public class Ticket implements Runnable {

    //默认两百张票
    private static int count = 200;

    @Override
    public void run() {
        //假设窗口A进来，B
        while (count > 0) {
            try {
                //当A睡眠时，B进入任务，注意：多个线程睡眠过后并不是按顺序获取CPU资源的
                Thread.sleep(300);
                //Thread.currentThread().getName()获取当前线程的名字
                System.out.println(Thread.currentThread().getName() + "卖出，剩余" + (--count));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
