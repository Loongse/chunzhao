package GC;

//验证虚拟机中栈（栈帧的局部变量）中引用的对象为GC root
public class GCRootLocalVariablel {
    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];//80MB

    public static void main(String[] args) {
        System.out.println("开始时:");
        printMemory();
        method();
        System.gc();
        System.out.println("第二次GC完成");
        printMemory();
    }

    public static void method() {
        //验证局部变量作为GC root
        GCRootLocalVariablel g = new GCRootLocalVariablel();
        System.gc();
        System.out.println("第一次GC完成");
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
