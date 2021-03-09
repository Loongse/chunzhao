package CVTE;

//交替打印HiCvte
public class Main02 {
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(demo::printHi).start();
        new Thread(demo::printCvte).start();
    }
}

class Demo {
    public synchronized void printHi() {
        while (true) {
            synchronized (this) {
                notify();//唤醒其他线程
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("Hi");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printCvte() {
        while (true) {
            synchronized (this) {
                notify();//唤醒其他线程
                System.out.print("Cvte");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
