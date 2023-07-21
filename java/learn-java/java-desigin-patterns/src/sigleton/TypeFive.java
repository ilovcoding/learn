package sigleton;

// 采用 synchronized 解决懒汉式，线程不安全问题
// 但是锁住整个方法效率有点低 TypeFour 错误的示范，这样修改不能保证单例
//
public class TypeFive {
    public static TypeFive INSTANCE;

    private TypeFive() {
    }

    public static TypeFive getInstance() {
        if (INSTANCE == null) {
            synchronized (TypeFive.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                INSTANCE = new TypeFive();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(TypeFive.getInstance().hashCode());
            }).start();
        }
    }
}
