package cc.fireflyhut.selftech.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class TestNewScheduledThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestNewScheduledThreadPool nstp = new TestNewScheduledThreadPool();
        nstp.testNewScheduledThreadPool();
    }

    public void testNewScheduledThreadPool() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println("程序开始执行 " + sdf.format(new Date()));

        // 创建scheduled线程池
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(3);

        // 设定延迟三秒执行
        ScheduledFuture f1 = scheduledThreadPool.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟3秒 " + sdf.format(new Date()));
            }
        }, 3, TimeUnit.SECONDS);

        // 设定延迟一秒执行，后每三秒执行一次
        ScheduledFuture f2 = scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次 " + sdf.format(new Date()));
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
