package AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//自定义AQS来实现同步机制

/**
 * MyLock是一个最简单的独占锁，通过使用MyLock也能实现同synchronized和ReentrantLock相同的功能
 */
public class MyLock {
    private Sync sync = new Sync();

    /**
     * 枷锁
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 释放锁
     */
    public void unlock() {
        sync.release(1);
    }

    static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }


        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }
    }
}
