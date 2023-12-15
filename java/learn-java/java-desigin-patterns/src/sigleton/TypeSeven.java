package sigleton;

// 静态内部类
// JVM 保证单例 加载外部类时不会加载内部类，这样可以实现懒加载
public class TypeSeven {
    private static class InnerClass {
        public static TypeSeven INSTANCE = new TypeSeven();
    }
    public static TypeSeven getInstance(){
        return InnerClass.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            new Thread(()->{
                System.out.println(TypeSeven.getInstance().hashCode());
            }).start();
        }
    }
}
