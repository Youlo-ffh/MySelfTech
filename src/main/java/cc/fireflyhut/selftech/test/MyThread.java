package cc.fireflyhut.selftech.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

    @Override
    public void run() {
        while (!isInterrupted()){  // 非阻塞过程中通过判断中断标志来退出
            try{
                System.out.println("开始睡觉~ " + sdf.format(new Date()));
                Thread.sleep(5 * 1000);  // 阻塞过程捕获中断异常来退出
                System.out.println("我睡醒啦~ " + sdf.format(new Date()) + "\n");
            } catch (InterruptedException e){
                System.out.println(e.getMessage() + " " + sdf.format(new Date()));
                break;  // 捕获到异常之后，执行break跳出循环
            }
        }
    }

}
