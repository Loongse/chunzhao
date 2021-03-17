package GC;

//验证虚拟机中栈（栈帧的局部变量）中引用的对象为GC root
public class GCRootStaticVariable {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;
    private static GCRootStaticVariable staticVariable;

    public GCRootStaticVariable(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        System.out.println("开始时:");
        printMemory();
        GCRootStaticVariable g = new GCRootStaticVariable(4 * _10MB);
        staticVariable = new GCRootStaticVariable(8 * _10MB);
        g = null;
        //将G设置为null，调用GC时可用回收此对象内存
        System.gc();
        System.out.println("第二次GC完成");
        printMemory();
    }

    /**
     * 打印当前JVM剩余空间和总的空间大小
     */
    private static void printMemory() {
        System.out.println("free is " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");
        System.out.println("total is " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "MB");
    }

}
