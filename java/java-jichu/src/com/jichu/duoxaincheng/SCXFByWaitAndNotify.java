package com.jichu.duoxaincheng;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

//通过wait/notify来实现
public class SCXFByWaitAndNotify {
    public static void main(String[] args) {

    }
}

//生产者类
class ProducerW implements Runnable {
    private final BlockingQueue<Integer> queue;

    public ProducerW(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);//模拟耗时
                queue.put(produce());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer produce() {
        int n = new Random().nextInt(10000);
        System.out.println("Thread:" + Thread.currentThread().getId() + "" +
                " produce:" + n);
        return n;
    }
}

//消费者
class ConsumerW implements Runnable {
    private final BlockingQueue<Integer> queue;

    public ConsumerW(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //模拟耗时
                Thread.sleep(2000);
                consume(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume(Integer take) {
        System.out.println("Thread:" + Thread.currentThread().getId() + " comsume:" + take);
    }
}
