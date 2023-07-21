package netty.api_reactor;

// 这里不做 IO 或者 业务的数据
public class MainThread {
    public static void main(String[] args) {
//      创建 IO Thread (一个或者多个)
//        boss 有自己的线程组
        SelectorThreadGroup boss = new SelectorThreadGroup(3);
//        worker 也有自己的线程组
        SelectorThreadGroup worker = new SelectorThreadGroup(3);
//        boss 里面得持有 worker 的 引用。
        boss.setWorker(worker);
        boss.bind(9999);
        boss.bind(9998);
        boss.bind(9997);
    }
}
