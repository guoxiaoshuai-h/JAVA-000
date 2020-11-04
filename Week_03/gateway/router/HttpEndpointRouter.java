package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-04 18:32
 */
public class HttpEndpointRouter {

    private static AtomicInteger count = new AtomicInteger(0);

    public static String route(List<String> endpoints) {
        if (endpoints != null) {
            return endpoints.get(count.getAndIncrement() % endpoints.size());
        }
        return null;
    }
}
