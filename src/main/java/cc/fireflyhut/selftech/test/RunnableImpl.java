package cc.fireflyhut.selftech.test;

public class RunnableImpl extends OtherClass implements Runnable {
    @Override
    public void run() {
        System.out.println("新的线程跑起来啦~");
    }
}
