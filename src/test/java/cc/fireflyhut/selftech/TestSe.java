package cc.fireflyhut.selftech;

import cc.fireflyhut.selftech.test.MyCallableImpl;
import cc.fireflyhut.selftech.test.MyReentrantLockTest;
import cc.fireflyhut.selftech.test.MyThread;
import cc.fireflyhut.selftech.test.RunnableImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.SimpleFormatter;

@SpringBootTest
public class TestSe {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        String input = "ReentrantLock 相比 synchronized 的优势是可中断、公平锁、多个锁。这种情况下需要\n" +
                "使用 ReentrantLock。";


        input = input.replaceAll("[\n\\s+]", "");
        input = input.replaceAll(",", "，");

        System.out.println("\n" + input);
    }


    Thread thread = new Thread();

    @Test
    public void testThread() {

        MyThread myt = new MyThread();
        myt.start();
    }

    @Test
    public void testRunnable() {
        RunnableImpl runnableImpl = new RunnableImpl();
        Thread thread = new Thread(runnableImpl);
        thread.start();
    }

    @Test
    public void testThreadPool1() throws ExecutionException, InterruptedException {
        int taskNum = 50;
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskNum);

        // 执行任务并获取Future结果
        List<Future> resList = new ArrayList<Future>();
        for (int i = 0; i < taskNum; i++) {
            Callable c = new MyCallableImpl();
            Future f = pool.submit(c);
            resList.add(f);
        }

        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的执行结果
        for (Future<String> res : resList) {
            System.out.println(res.get());
        }
    }


    @Test
    public void testThreadPool2() {

        // 通过ExecutorService创建线程池
        int taskSize = 10;
        ExecutorService threadPool = Executors.newFixedThreadPool(taskSize);
        while(true) {
            threadPool.execute(new Runnable() {  // 提交多个线程任务，并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(3000);  // 睡3秒
                    } catch (InterruptedException e) {
                        System.err.println("睡眠被打断");
                    }
                }
            });
        }
    }

    @Test
    public void testNewScheduledThreadPool() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println("程序开始执行 " + sdf.format(new Date()));

        // 创建scheduled线程池
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(3);

        // 设定延迟三秒执行
        ScheduledFuture f1 = scheduledThreadPool.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟三秒 " + sdf.format(new Date()));
            }
        }, 3, TimeUnit.SECONDS);

        // 设定延迟一秒执行，后没三秒执行一次
        ScheduledFuture f2 = scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run() {
                System.out.println("延迟1秒后每三秒执行一次 " + sdf.format(new Date()));
            }
        },1,3,TimeUnit.SECONDS);


    }

    @Test
    public void testInterruptThread() throws InterruptedException {
        MyThread mt = new MyThread();  // 新建线程
        mt.start();  // 就绪
        Thread.sleep(9 * 1000);  // 9秒后打断线程
        mt.interrupt();  // 打断线程
    }

    @Test
    public void testReentrantLock() {
        MyReentrantLockTest myReentrantLockTest = new MyReentrantLockTest();

        myReentrantLockTest.testLockMethod();
    }

}












