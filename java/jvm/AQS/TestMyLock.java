package AQS;

//测试自定义锁
public class TestMyLock {
    static int count = 0;
    static MyLock myLock = new MyLock();

    public static void main(String[] args) throws InterruptedException {
        new TestMyLock().testMyLock();
    }

    public void testMyLock() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                myLock.lock();
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unlock();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
