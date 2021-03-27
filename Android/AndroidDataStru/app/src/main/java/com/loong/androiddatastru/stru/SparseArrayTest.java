package com.loong.androiddatastru.stru;

import android.util.SparseArray;

/**
 * @author LOONG
 * @version 1.0
 * @description: SparseArray<E>相当于Map< Integer,E > ，key值固定为int类型，在初始化时只需要声明Value的数据类型即可，其内部用两个数组分别来存储Key列表和Value列表：int[] mKeys和Object[] mValues。
 * @date 2021/3/27 13:56
 */
public class SparseArrayTest {
    public void useSparseArray() {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(100, "leavesC");
        sparseArray.remove(100);
        sparseArray.get(100);
        sparseArray.removeAt(29);
    }
}
