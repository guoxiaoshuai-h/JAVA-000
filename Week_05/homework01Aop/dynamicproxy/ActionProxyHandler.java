package fx.gxs.week05.homework01Aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 10:14
 */
public class ActionProxyHandler implements InvocationHandler {

    private Object object;

    public ActionProxyHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(object, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("dynamic proxy before");
    }

    private void after() {
        System.out.println("dynamic proxy after");
    }
}
