package cn.yunhe.thread;

public class InterruptTest {

    public static void main(String[] args) {
        Object obj = new Object();
        InterruptThread in1 = new InterruptThread(obj);
        InterruptThread in2 = new InterruptThread(obj);

        Thread t1 = new Thread(in1, "窗口A");
        Thread t2 = new Thread(in2, "窗口B");

        t1.start();
        t2.start();

        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(1000);
                if (i % 2 == 0) {
                    //强制中断指定线程
                    t1.interrupt();
                    t2.interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
