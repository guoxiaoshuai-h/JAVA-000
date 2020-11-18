package fx.gxs.week05.homework01Aop.cglibproxy;

import fx.gxs.week05.homework01Aop.dynamicproxy.ActionImpl;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-17 10:36
 */
public class CGLibProxyTest {

    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        ActionImpl proxy = cgLibProxy.getProxy(ActionImpl.class);
        proxy.jeap();
        System.out.println(proxy.getClass());  //CGLib动态代理,class fx.gxs.week05.homework01.dynamicproxy.ActionImpl$$EnhancerByCGLIB$$c47622ab
    }
}
