package cn.yunhe.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Excutorteset01 {
    public static void main(String[] args) {

        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 50; i++) {
            final int index = i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("第" + index + "个线程" + Thread.currentThread().getName());
                }
            });
        }
        cacheThreadPool.shutdown();
    }
}
