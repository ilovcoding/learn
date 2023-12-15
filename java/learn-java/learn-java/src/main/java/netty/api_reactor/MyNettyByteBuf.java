package netty.api_reactor;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;


public class MyNettyByteBuf {
    @Test
    public void myByteBuf() {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(8, 20);
        print(buf);
        buf.writeBytes(new byte[]{1, 2, 3, 4});
        print(buf);
    }

    public static void print(ByteBuf buf) {
        System.out.println(buf.isReadable());
        System.out.println(buf.readerIndex());
        System.out.println(buf.readableBytes());
        System.out.println(buf.isWritable());
        System.out.println(buf.writerIndex());
        System.out.println(buf.writableBytes());
        System.out.println(buf.capacity());
        System.out.println(buf.maxCapacity());
        System.out.println(buf.isDirect());
        System.out.println("--------");
    }
}
