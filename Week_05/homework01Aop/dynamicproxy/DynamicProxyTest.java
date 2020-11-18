package fx.gxs.week05.homework01Aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 10:17
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        ActionImpl action = new ActionImpl();
        Class<?>[] interfaces = action.getClass().getInterfaces();
        ClassLoader classLoader = action.getClass().getClassLoader();
        InvocationHandler handler = new ActionProxyHandler(action);
        Action proxy = (Action)Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxy.move();
        System.out.println("==========================");
        proxy.jeap();
        System.out.println(proxy.getClass());   //jdk动态代理，class com.sun.proxy.$Proxy0
    }
}
