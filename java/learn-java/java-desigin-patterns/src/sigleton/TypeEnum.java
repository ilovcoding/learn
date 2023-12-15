package sigleton;

// 枚举值
// 不仅可以解决线程同步，还可以防止反序列化。
public enum TypeEnum {

    INSTANCE;

    public void S() {}

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            new Thread(()->{
                System.out.println(TypeEnum.INSTANCE.hashCode());
            }).start();
        }
    }

}
