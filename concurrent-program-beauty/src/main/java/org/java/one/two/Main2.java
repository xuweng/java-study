package org.java.one.two;

import java.util.concurrent.Callable;

/**
 * https://blog.csdn.net/kealina/article/details/78376795
 * <p>
 * IDEA快捷键设置复制上一行
 */
public class Main2 {
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {

    }
}
