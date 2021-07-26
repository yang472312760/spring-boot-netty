package com.yang.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import org.springframework.stereotype.Component;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.netty</p>
 * <p>@ClassName:BingoChannelOnboundHandler</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2019/12/24 10:39</p>
 * <p>@Version:1.0</p>
 */
@Component
@ChannelHandler.Sharable
public class BingoChannelOutboundHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ReferenceCountUtil.refCnt(msg);
        promise.setSuccess();
    }
}
