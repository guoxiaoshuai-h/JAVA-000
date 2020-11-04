package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-11-04 18:22
 */
public class HttpRequestFilterImpl implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        if (fullRequest != null) {
            fullRequest.headers().set("nio","hello,nio");
        }
    }
}
