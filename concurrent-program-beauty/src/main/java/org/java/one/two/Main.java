package org.java.one.two;

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
