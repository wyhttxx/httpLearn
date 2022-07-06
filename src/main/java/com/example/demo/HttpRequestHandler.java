package com.example.demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        System.out.println(fullHttpRequest.uri());
        System.out.println(fullHttpRequest.content().toString(CharsetUtil.UTF_8));
        String msg="<html><h1>万宇航学习之王</h1></html>";
        FullHttpResponse fullHttpResponse=new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK,
                Unpooled.copiedBuffer(msg,CharsetUtil.UTF_8)
                );
        fullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/html;charset=UTF-8");
        channelHandlerContext.writeAndFlush(fullHttpResponse).addListener(ChannelFutureListener.CLOSE);
    }


}
