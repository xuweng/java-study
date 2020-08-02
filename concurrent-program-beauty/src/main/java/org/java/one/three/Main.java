package org.java.one.three;

import java.util.LinkedList;
import java.util.Queue;

class Example {
    private static Queue<Integer> queue = new LinkedList<>();
    private final static int MAX_SIZE = 100000;

    public static class ProducerThread {
        public void produce(int value) {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    try {
                        //挂起当前线程，并释放通过同步块获取的queue的锁。让其他线程来唤醒，否则会一直等待。
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.offer(value);
                //唤醒消费者线程
                queue.notifyAll();
            }
        }
    }

    public static class ConsumerThread {
        public void consumption() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();
                queue.notifyAll();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            new Example.ProducerThread().produce(1);
        });

        new Thread(() -> {
            new Example.ConsumerThread().consumption();
        });
    }
}
