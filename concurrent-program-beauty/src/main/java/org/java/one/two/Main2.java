package org.java.one.two;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * https://blog.csdn.net/kealina/article/details/78376795
 * <p>
 * IDEA快捷键设置复制上一行
 */
public class Main2 {
    //创建任务类，类似Runnable
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            //等待3s
            Thread.sleep(3000);
            return "hello";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        //等待任务执行完毕，并返回结果
        //调用get会阻塞调用者线程，即main线程
        String result = futureTask.get();

        System.out.println(result);
    }
}
