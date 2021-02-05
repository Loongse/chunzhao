package com.jichu.duoxaincheng;

//不同阻塞方法
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        //使用wait和notify的示例
        Object obj = new Object();
        synchronized (obj) {
            while (Thread.holdsLock(obj)) {
                //唤醒
                obj.wait();//唤醒
            }
        }
    }
}
