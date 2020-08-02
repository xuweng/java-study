package org.java.one.two;

/**
 * 看书的同时跑一下书本里面的代码。仅仅看是没用的。
 * <p>
 * 看书+跑代码。
 */
public class Main {
    public static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("ha");
        }
    }

    public static void main(String[] args) {
        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
    }
}
