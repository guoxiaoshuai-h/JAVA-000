package java0.conc0303.homework;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-10 19:09
 */
public class FirstByJoin {

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
        Thread thread = new Thread(() -> res = sum());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(res);
    }
}
