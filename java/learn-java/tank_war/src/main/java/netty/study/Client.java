package netty.study;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        try {
         ChannelFuture f =  b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer())
                    .connect("localhost",8888);
         f.addListener(new ChannelFutureListener() {
             @Override
             public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(channelFuture.isSuccess()){
                    System.out.println("connected");
                }else {
                    System.out.println("not connected");
                }
             }
         });
         f.sync();
         f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}

class ClientChannelInitializer extends  ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println(socketChannel);
        socketChannel.pipeline().addLast(new ClientHandler());
    }
}

class  ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = null;
        try {
            buf = (ByteBuf) msg;
            byte[] bytes = new byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(), bytes);
            System.out.println(new String(bytes));
        } finally {
            if (buf != null){
                ReferenceCountUtil.release(buf);
                System.out.println(buf.refCnt());
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        ByteBuf buf = Unpooled.copiedBuffer("hello".getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(buf);
    }
}