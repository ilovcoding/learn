package netty.api_reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class SelectorThreadGroup {
    SelectorThread[] sts;
    ServerSocketChannel server = null;
    AtomicInteger xid = new AtomicInteger(0);
    SelectorThreadGroup stg = this;

    /**
     * @param num 线程数
     */
    SelectorThreadGroup(int num) {
        sts = new SelectorThread[num];
        for (int i = 0; i < num; i++) {
            sts[i] = new SelectorThread(this);
            new Thread(sts[i]).start();
        }
    }

    public void bind(int port) {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));
            nextSelectorV2(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void nextSelectorV2(Channel c) {
        try {

            if (c instanceof ServerSocketChannel) {
                SelectorThread bst = next();
                bst.lbq.put(c);
                bst.setWorker(stg);
                bst.selector.wakeup();
            } else {
                SelectorThread wst = stg.next();
                wst.lbq.put(c);
                wst.selector.wakeup();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //    无论 server 是 serverSocket 还是 socket 都适用这个方法。
    public void nextSelector(Channel c) {
        SelectorThread st = next();
//         1. 通过队列传递消息
        st.lbq.add(c);
        st.selector.wakeup();
    }

    public SelectorThread next() {
        int index = xid.incrementAndGet() % stg.sts.length;
        return stg.sts[index];
    }

    public void setWorker(SelectorThreadGroup worker) {
        this.stg = worker;
    }
}
