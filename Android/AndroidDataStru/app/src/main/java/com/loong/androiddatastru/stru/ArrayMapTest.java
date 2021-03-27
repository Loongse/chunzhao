package com.loong.androiddatastru.stru;

import android.os.Build;
import android.util.ArrayMap;

import androidx.annotation.RequiresApi;

import java.util.function.BiConsumer;

/**
 * @author LOONG
 * @version 1.0
 * @description: ArrayMap是一种通用的key-value映射的数据结构，旨在提高内存效率，它与传统的HashMap有很大的不同。它将其映射保留在数组数据结构中：
 * 两个数组（其中一个存放每个item的hash值的整数数组，以及key/value对的Object数组）。
 * 这避免了它为放入映射的每个item创建额外的对象，并且它还积极地控制这些数组的增长。
 * 数组的增长只需要复制数组中的item，而不是重建hash映射。
 * @date 2021/3/27 11:17
 */

public class ArrayMapTest {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void useArrayMap() {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("a","b");
        arrayMap.forEach((s, s2) -> {
            
        });
    }
}
/**
 * @description: 适用场景：
 * 数据量不大
 * 空间比时间重要
 * 需要使用Map
 * 在Android平台，相对来说，内存容量更宝贵。而且数据量不大。所以当需要使用key是Object类型的Map时，可以考虑使用ArrayMap来替换HashMap
 * @author LOONG
 * @date 2021/3/27 14:12
 * @version 1.0
 */