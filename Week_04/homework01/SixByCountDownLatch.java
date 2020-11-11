package java0.conc0303.homework;

import java.util.concurrent.CountDownLatch;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-11 09:47
 */
public class SixByCountDownLatch {

    private static int res;

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new MyThread(countDownLatch).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    private static class MyThread extends Thread {

        private CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            res = sum();
            countDownLatch.countDown();
        }
    }
}


