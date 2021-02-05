package com.jichu.duoxaincheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//通过wait/notify来实现
public class SCXFByWaitAndNotify {
    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        ProducerW producerW = new ProducerW(queue);
        ConsumerW consumerW = new ConsumerW(queue);
        ConsumerW consumerW1 = new ConsumerW(queue);
        new Thread(producerW).start();
        new Thread(consumerW1).start();
        new Thread(consumerW).start();
    }

}

//生产者类
class ProducerW implements Runnable {
    private final List<Integer> queue;

    public ProducerW(List<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void produce() throws InterruptedException {
        int capacity = 5;//产品容器容量
        synchronized (queue) {
            //当容器满了停止生产
            while (queue.size() == capacity) {
                System.out.println("容器已满暂停生产...");
                queue.wait();
            }
            Random r = new Random();
            int p = r.nextInt(50);
            //模拟一秒生产一个产品
            Thread.sleep(1000);
            System.out.println("生产产品");
            queue.add(p);
            queue.notifyAll();
        }
    }
}

//消费者
class ConsumerW implements Runnable {
    private final List<Integer> queue;

    public ConsumerW(List<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                //停止消费
                System.out.println("...容器为空，暂停消费...");
                queue.wait();
            }
            Integer p = queue.remove(0);
            //模拟耗时
            Thread.sleep(1000);
            System.out.println("消费产品："+p);
            queue.notifyAll();
        }
    }
}
