package cn.yunhe.thread;

public class InterruptThread implements Runnable {

    private Object obj;
    private int count = 200;

    public InterruptThread() {
    }

    public InterruptThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (count > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName());
//						Thread.sleep(1000);
//						obj.notify();
                        obj.wait();
                        System.out.println(Thread.currentThread().getName() + "持有锁" + (--count));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
