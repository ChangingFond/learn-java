/**
 * Copyright 2021, Xiaomi.
 * All rights reserved.
 * Author: fangchengjin@xiaomi.com
 */
package com.changingfond.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder {

  // ReplayingDecoder<Void>
  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
    if (in.readableBytes() < 4) {
      return;
    }

    out.add(new UnixTime(in.readUnsignedInt()));
  }
}
