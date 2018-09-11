package com.imooc.ThreadDemo;

import java.io.*;
import java.util.Scanner;

/**
 * Created by xj on 2018/9/11.
 */
class DemonThread implements Runnable{

    @Override
    public void run() {
        System.out.println("进入守护线程"+Thread.currentThread().getName());
        try {
            writeFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("退出守护线程"+Thread.currentThread().getName());
    }
    private void writeFile() throws IOException, InterruptedException {
        File filename=new File("F:"+File.separator+"daemon.txt");

            OutputStream os=new FileOutputStream(filename,true);
            int count=0;
            while(count<999){
                os.write(("\r\nword"+count).getBytes());
                System.out.println("守护线程"+Thread.currentThread().getName()
                +"向文件中写入了world"+count++);
                Thread.sleep(1000);
            }

    }
}
public class DemoThreadDemo {
    public static void main(String[] args){
        System.out.println("进入主线程"+Thread.currentThread().getName());
        DemonThread t=new DemonThread();
        Thread thread=new Thread(t);
        thread.setDaemon(true);
        thread.start();
        Scanner sc=new Scanner(System.in);
        sc.next();//输入了字符,主线程就会获得cpu,然后执行下面的代码,结束主线程,守护线程也灭了
        System.out.println("退出主线程"+Thread.currentThread().getName());
    }
}
