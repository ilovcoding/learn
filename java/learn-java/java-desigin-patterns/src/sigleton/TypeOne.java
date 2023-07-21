package sigleton;

// 饿汉式
public class TypeOne {
    public static final TypeOne INSTANCE = new TypeOne();
    private TypeOne(){}

    private static TypeOne getInstance() {
        return INSTANCE;
    }
    public static void main(String[] args) {
        TypeOne t1 = TypeOne.getInstance();
        TypeOne t2 = TypeOne.getInstance();
        System.out.println(t1==t2);
    }

}
