package com.imooc.ThreadDemo;

/**
 * Created by xj on 2018/9/11.
 */

class MyThread2 implements Runnable{
    private int ticketsCont=5;//一共5张票
    @Override
    public void run() {
        while(ticketsCont>0){
            ticketsCont--;
            System.out.println(Thread.currentThread().getName()+"买了一张票,剩余票数为"+ticketsCont);
        }
    }
}
public class RunnableDemo {
    public static void main(String[] args){
        MyThread2 mt=new MyThread2();
        //创建三个线程,模拟三个窗口
        Thread th1=new Thread(mt,"窗口1");
        Thread th2=new Thread(mt,"窗口2");
        Thread th3=new Thread(mt,"窗口3");
        th1.start();//线程启动,等待cpu资源
        th2.start();
        th3.start();
    }
}
