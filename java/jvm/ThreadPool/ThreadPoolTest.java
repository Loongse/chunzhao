package ThreadPool;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
//        useSingleThreadExecutor();
//        useCachedThreadPool();
//        useFixedThreadPool();
        useScheduledThreadPool();
    }

    /**
     * 使用单线程化的线程池，只会用唯一的工作线程执行任务，保证所有任务按照先进先出的顺序执行
     */
    public static void useSingleThreadExecutor() throws InterruptedException {
        //创建单线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int taskId = i + 1;
            //向线程池提交任务
            singleThreadExecutor.submit(() -> System.out.println("线程：" +
                    Thread.currentThread().getName() +
                    " 正在执行 task:" + taskId));
            Thread.sleep(1000);
        }
        singleThreadExecutor.shutdown();
    }

    /**
     * 使用可缓存线程池，如果有空闲会尝试回收，如果若无可回收则创建新线程
     */
    public static void useCachedThreadPool() throws InterruptedException {
        //创建单线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int taskId = i + 1;
            //此时休眠1秒说明线程空闲，不需要创建新的线程完成任务所以与单线程池一致
            Thread.sleep(1000);
            //向线程池提交任务
            cachedThreadPool.submit(() -> {
                try {
                    System.out.println("线程：" +
                            Thread.currentThread().getName() +
                            " 正在执行 task:" + taskId);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        cachedThreadPool.shutdown();
    }

    /**
     * 使用固定大小线程池
     */
    public static void useFixedThreadPool() throws InterruptedException {
        //创建单线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int taskId = i + 1;
            //向线程池提交任务
            fixedThreadPool.submit(() -> System.out.println("线程：" +
                    Thread.currentThread().getName() +
                    " 正在执行 task:" + taskId));
            Thread.sleep(1000);
        }
        fixedThreadPool.shutdown();
    }

    /**
     * 使用定时线程池，支持定时与周期性的任务执行
     */
    public static void useScheduledThreadPool() throws InterruptedException {
        //创建单线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        //向线程池提交任务
        //每隔0.5秒调用任务
        scheduledThreadPool.scheduleAtFixedRate(() -> {
            Date now = new Date();
            System.out.println("线程：" +
                    Thread.currentThread().getName() +
                    " 正在执行 task:" + now);
        }, 500, 500, TimeUnit.MILLISECONDS);

        Thread.sleep(5000);
        scheduledThreadPool.shutdown();
    }

}
