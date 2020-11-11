package java0.conc0303.homework;

import java.util.concurrent.Semaphore;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-11 09:42
 */
public class FiveBySemaphore {

    private static int value;

    private static Semaphore signal = new Semaphore(1);

    private static void sum() {
        try {
            signal.acquire();
            value = fibo(36);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            signal.release();
        }
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private static int getValue() {
        int res = 0;
        try {
            signal.acquire();
            res = value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            signal.release();
        }
        return res;
    }

    public static void main(String[] args) {

        new Thread(() -> sum()).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = getValue();
        System.out.println(result);
    }

}
