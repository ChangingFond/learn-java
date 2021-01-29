/**
 * Copyright 2021, Xiaomi.
 * All rights reserved.
 * Author: fangchengjin@xiaomi.com
 */
package com.changingfond.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

  /**
   * we are going to ignore any received data but to send a message as soon as a connection is established,
   * we cannot use the channelRead() method this time. Instead, we should override the channelActive() method.
   * channelActive() method will be invoked when a connection is established and ready to generate traffic.
   */
  @Override
  public void channelActive(final ChannelHandlerContext ctx) {
    // Netty buffer don't need to flip() like java NIO because of two separate pointers.
    final ByteBuf time = ctx.alloc().buffer(4);
    time.writeInt((int) (System.currentTimeMillis() / 1000 + 2208988800L));
    /**
     * A ChannelFuture represents an I/O operation which has not yet occurred.
     * Any requested operation might not have been performed yet because all operations are asynchronous in Netty.
     * For example, the following code might close the connection even before a message is sent:
     *    Channel ch = ...;
     *    ch.writeAndFlush(message); // asynchronous
     *    ch.close();
     */
    final ChannelFuture f = ctx.writeAndFlush(new UnixTime());
    /**
     * We created a new anonymous ChannelFutureListener which closes the Channel when the operation is done.
     * Alternatively, you could simplify the code using a pre-defined listener:
     *    f.addListener(ChannelFutureListener.CLOSE);
     */
    f.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture channelFuture) throws Exception {
        assert f == channelFuture;
        ctx.close();
      }
    });
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
