package GC;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

public class SoftReferenceTest {
    public static class SoftObject {
        byte[] data = new byte[1024];//1kb
    }

    public static int removedSoftRefs = 0;
    public static int CACHE_INITIAL_CAPACITY = 100 * 1024;//100m

    //静态集合保存引用会导致软引用对象本身无法被垃圾回收器回收
    public static Set<SoftReference<SoftObject>> cache = new HashSet<>(CACHE_INITIAL_CAPACITY);
    public static ReferenceQueue<SoftObject> referenceQueue = new ReferenceQueue<>();

    public static void main(String[] args) {
        for (int i = 0; i < CACHE_INITIAL_CAPACITY; i++) {
            SoftObject obj = new SoftObject();
            cache.add(new SoftReference<>(obj, referenceQueue));
            clearUselessSoftRefs();
            if (i % 10000 == 0) {
                System.out.println("size of cache:" + cache.size());
            }
        }
        System.out.println("End!");
    }

    private static void clearUselessSoftRefs() {
        Reference<? extends SoftObject> ref =referenceQueue.poll();
        while (ref != null){
            if(cache.remove(ref)){
                removedSoftRefs++;
            }
            ref = referenceQueue.poll();
        }
    }
    //注册一个引用队列，即时清除队列中的软引用达到回收目的

}
