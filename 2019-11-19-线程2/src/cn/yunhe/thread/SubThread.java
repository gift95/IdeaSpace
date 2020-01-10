package cn.yunhe.thread;

public class SubThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "--" + i + "--优先级：" + Thread.currentThread().getPriority());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
