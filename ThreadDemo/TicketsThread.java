package com.imooc.ThreadDemo;

/**
 * Created by xj on 2018/9/11.
 */
class MyThread extends Thread{
    private int ticketsCont=5;//一共5张票
    private String name;//窗口,即线程的名字

    public MyThread(String name){
        this.name=name;
    }
    @Override
    public void run(){
        while(ticketsCont>0){
            ticketsCont--;
            System.out.println(name+"买了一张票,剩余票数为"+ticketsCont);
        }
    }
}

public class TicketsThread {
    public static void main(String[] args){
        //创建三个线程,模拟三个窗口
        MyThread m1=new MyThread("窗口1");
        MyThread m2=new MyThread("窗口2");
        MyThread m3=new MyThread("窗口3");

        m1.start();
        m2.start();
        m3.start();
    }
}
