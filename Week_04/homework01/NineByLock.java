package java0.conc0303.homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-11 10:19
 */
public class NineByLock {

    private static int res;

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static void sum() {
        lock.lock();
        try {
            res = fibo(36);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    private static int getValue() {
        lock.lock();
        try {
            while (res == 0) {
                    condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public static void main(String[] args) {

        new Thread(() -> sum()).start();

        System.out.println(getValue());
    }

}
