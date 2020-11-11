package java0.conc0303.homework;

import java.util.concurrent.CompletableFuture;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-11 11:21
 */
public class TenByCompletableFuture {

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public static void main(String[] args) {
        Integer res = CompletableFuture.supplyAsync(TenByCompletableFuture::sum).join();

        System.out.println(res);
    }
}
