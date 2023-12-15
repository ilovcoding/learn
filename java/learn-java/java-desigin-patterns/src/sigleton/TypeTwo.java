package sigleton;

// 懒汉式静态代码快
public class TypeTwo {
    private  final static  TypeTwo INSTANCE;
    static {
        INSTANCE = new TypeTwo();
    }
    private TypeTwo(){}
    public static TypeTwo getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TypeTwo t1 = TypeTwo.getInstance();
        TypeTwo t2 = TypeTwo.getInstance();
        System.out.println(t1==t2);
    }
}
