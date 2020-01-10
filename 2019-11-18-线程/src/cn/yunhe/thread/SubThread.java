package cn.yunhe.thread;

public class SubThread /*extends Thread*/ implements Runnable {

    @Override
    public void run() {
        //要执行的任务
        System.out.println("售票");
    }

}
