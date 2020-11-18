package fx.gxs.week05.homework01Aop.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 10:33
 */
public class CGLibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(obj, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("CGLib proxy before");
    }

    private void after() {
        System.out.println("CGL proxy after");
    }
}
