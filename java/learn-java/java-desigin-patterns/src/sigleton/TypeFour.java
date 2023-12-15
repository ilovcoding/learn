package sigleton;

// 采用 synchronized 解决懒汉式，线程不安全问题
// 但是锁住整个方法效率有点低
public class TypeFour {
    public static TypeFour INSTANCE;
    private TypeFour(){}
    public static synchronized TypeFour getInstance() {
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE = new TypeFour();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(TypeFour.getInstance().hashCode());
            }).start();
        }
    }
}
