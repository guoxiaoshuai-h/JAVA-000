package java0.conc0303.homework;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-10 19:20
 */
public class FourBySynchronized {
    private static int res;

    private static Object object = new Object();

    private static void sum() {
        synchronized (object) {
            res = fibo(36);
            object.notify();
        }

    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    private static int getValue() {
        synchronized (object) {
            while (res == 0) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        new Thread(() -> sum()).start();

        System.out.println(getValue());
    }
}
