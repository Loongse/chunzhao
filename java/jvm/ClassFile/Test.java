package ClassFile;

import java.io.Serializable;

//class文件结构详解
public class Test implements Serializable, Cloneable {
    private int num = 1;

    public int add(int i) {
        int j = 10;
        num = num + 1;
        return num;
    }
}
