package com.yang.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.netty</p>
 * <p>@ClassName:ChildChannelHandler</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2019/12/21 16:04</p>
 * <p>@Version:1.0</p>
 */
@Component
public class BingoChannel extends ChannelInitializer<io.netty.channel.socket.SocketChannel> {

    @Resource
    private BingoChannelInboundHandler bingoChannelInboundHandler;

    @Resource
    private BingoChannelOutboundHandler bingoChannelOutboundHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("http-codec", new HttpServerCodec());
        ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
        ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        ch.pipeline().addLast(bingoChannelInboundHandler);
    }
}
