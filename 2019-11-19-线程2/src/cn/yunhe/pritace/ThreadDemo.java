package cn.yunhe.pritace;

import java.util.concurrent.locks.Lock;


public class ThreadDemo extends Thread {
    private Lock lock;

    public ThreadDemo() {
    }

    public ThreadDemo(Lock lock) {
        this.lock = lock;
    }


    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            lock.lock();

            try {


                System.out.println(Thread.currentThread().getName() + "--" + i
                        + "优先级为" + Thread.currentThread().getPriority());
            } finally {
                lock.unlock();
            }

        }
    }
}
