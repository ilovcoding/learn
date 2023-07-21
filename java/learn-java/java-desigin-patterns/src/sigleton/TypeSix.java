package sigleton;

// 采用 synchronized 解决懒汉式，线程不安全问题
// 使用 double check 解决synchronized 锁住整个函数带来的低效率问题
//
public class TypeSix {
    // volatile 关键词 修饰保证内存可见性。（注意和指令重排序区分）
    // 关于指令重排序 https://segmentfault.com/a/1190000038355290
    public static volatile TypeSix INSTANCE;
    private TypeSix() {
    }

    public static TypeSix getInstance() {
        if (INSTANCE == null) {
            synchronized (TypeSix.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    INSTANCE = new TypeSix();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(TypeSix.getInstance().hashCode());
            }).start();
        }
    }
}
