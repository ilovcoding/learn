package netty.api_reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class SelectorThread implements Runnable {
//    每个线程对应一个 selector
//    多线程的情况下 该主机将程序的并发客户端分配到多个 selector
//    注意 每个客户端只绑定一个 selector

    Selector selector = null;
    SelectorThreadGroup stg = null;
    LinkedBlockingDeque<Channel> lbq = new LinkedBlockingDeque<>();

    public SelectorThread(SelectorThreadGroup stg) {
        try {
            this.stg = stg;
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        LOOP
        while (true) {
            try {
//                 1. select()
                System.out.println(Thread.currentThread().getName() + " : before select ....." + selector.keys().size());
                int nums = selector.select(); // 阻塞 wakeup()
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : after select ....." + selector.keys().size());
                if (nums > 0) {
//                    处理 selectKeys
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = keys.iterator();
//                  线性处理
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();
//                        复杂的是接收客户端过程
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        } else if (key.isWritable()) {

                        }
                    }
                }
//              3.   处理一项 task
                if (!lbq.isEmpty()) {
                    Channel c = lbq.take();
                    if (c instanceof ServerSocketChannel) {
                        ServerSocketChannel server = (ServerSocketChannel) c;
                        server.register(selector, SelectionKey.OP_ACCEPT);
                    } else if (c instanceof SocketChannel) {
                        SocketChannel client = (SocketChannel) c;
                        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
                        client.register(selector, SelectionKey.OP_READ, buffer);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void readHandler(SelectionKey key) {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel client = (SocketChannel) key.channel();
        buffer.clear();
        while (true) {
            try {
                int num = client.read(buffer);
                if (num > 0) {
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if (num == 0) {
                    break;
                } else if (num < 0) {
//                    客户端断开
                    System.out.println("clent: " + client.getRemoteAddress() + "closed.....");
                    key.cancel();
                    break;
                }
            } catch (IOException e) {

            }
        }
    }

    private void acceptHandler(SelectionKey key) {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        try {
            SocketChannel client = server.accept();
//            设置成非阻塞
            client.configureBlocking(false);
//            choose a selector register a client
            stg.nextSelector(client);
        } catch (IOException e) {

        }
    }

    public void setWorker(SelectorThreadGroup stgWorker) {
        this.stg = stgWorker;
    }
}
