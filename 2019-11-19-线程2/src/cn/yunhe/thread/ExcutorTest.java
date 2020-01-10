package cn.yunhe.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorTest {

    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService exService = Executors.newFixedThreadPool(3);

        //开启任务--有五个任务需要执行
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            exService.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        System.out.println(Thread.currentThread().getName() + "--" + index);
                        //给当前线程中的任务加上睡眠时间，代表当前任务需要耗时操作
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exService.shutdown();
    }
}
