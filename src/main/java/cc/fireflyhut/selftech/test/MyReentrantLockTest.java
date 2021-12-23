package cc.fireflyhut.selftech.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockTest {
    // 默认非公平锁
    private Lock lock = new ReentrantLock();

    // 公平锁
    //private Lock lock = new ReentrantLock(true);

    // 非公平锁
    //private Lock lock = new ReentrantLock(false);

    // 创建Condition
    private Condition condition = lock.newCondition();

    public void testLockMethod() {
        try {
            // 加锁
            lock.lock();

            // 1：wait 方法等待
            System.out.println("调用await()方法");
            // 通过创建Condition对象来使线程wait，必须先执行lock.lock方法获得锁
            condition.await();

            // 2：signal方法唤醒
            condition.signal();  // condition对象的signal方法可以唤醒wait线程

            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            // 释放锁
            lock.unlock();
        }
    }
}
