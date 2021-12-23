package cc.fireflyhut.selftech.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallableImpl implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(date);
    }
}
