/**
 * Copyright 2021, Xiaomi.
 * All rights reserved.
 * Author: fangchengjin@xiaomi.com
 */
package com.changingfond.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

  // ChannelInboundHandlerAdapter provides various event handler methods that you can override.

  /**
   * This method is called with the received message, whenever new data is received from a client.
   * Please keep in mind that it is the handler's responsibility to release any reference-counted object passed to the handler.
   * Usually, channelRead() handler method is implemented like the following:
   * public void channelRead(ChannelHandlerContext ctx, Object msg) {
   *     try {
   *         // Do something with msg
   *     } finally {
   *         ReferenceCountUtil.release(msg);
   *     }
   * }
   */
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    // printMsg(msg);

    /**
     * A ChannelHandlerContext object provides various operations that enable you to trigger various I/O events and operations.
     * Please note that we did not release the received message unlike we did in the printMsg() method.
     * It is because Netty releases it for you when it is written out to the wire.
     */
    ctx.write(msg);
    /**
     * ctx.write(Object) does not make the message written out to the wire.
     * It is buffered internally and then flushed out to the wire by ctx.flush().
     * Alternatively, you could call ctx.writeAndFlush(msg) for brevity.
     */
    ctx.flush();
  }

  private void printMsg(Object msg) {
    ByteBuf in = (ByteBuf) msg;
    try {
      // This inefficient loop can actually be simplified to:
      // System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII))
      while (in.isReadable()) {
        System.out.print((char) in.readByte());
        System.out.flush();
      }

    } finally {
      // Discard the received data silently.
      // or you can use in.release()
      ReferenceCountUtil.release(msg);
    }
  }

  /**
   * The exceptionCaught() event handler method is called with a Throwable when an exception was raised by Netty
   * due to an I/O error or by a handler implementation due to the exception thrown while processing events.
   * In most cases, the caught exception should be logged and its associated channel should be closed here,
   * although the implementation of this method can be different depending on what you want to do to deal with
   * an exceptional situation. You might want to send a response message with an error code before closing the connection.
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    // Close the connection when an exception is raised.
    cause.printStackTrace();
    ctx.close();
  }
}
