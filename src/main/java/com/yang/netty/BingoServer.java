package com.yang.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.netty</p>
 * <p>@ClassName:DiscardServer</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2019/12/21 16:04</p>
 * <p>@Version:1.0</p>
 */
@Component
@Slf4j
public class BingoServer {

    private final ServerBootstrap serverBootstrap = new ServerBootstrap();

    private final EventLoopGroup boss = new NioEventLoopGroup();

    private final EventLoopGroup work = new NioEventLoopGroup();

    /**
     * 通道适配器
     */
    @Resource
    private BingoChannel bingoChannel;

    @Resource
    private NettyConfig nettyConfig;

    public void close() {
        log.info("关闭服务器");
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }

    public void run() {

        int port = nettyConfig.getPort();

        serverBootstrap.group(boss, work).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO));
        try {
            serverBootstrap.childHandler(bingoChannel);
            log.info("netty服务器在[{}]端口启动监听", port);
            ChannelFuture f = serverBootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            this.close();
        }
    }

}
