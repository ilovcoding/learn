package sigleton;

// 懒汉式 lazy load
public class TypeThree {
    private static TypeThree INSTANCE;
    private TypeThree(){}
    public static TypeThree getInstance() {
        if(INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            INSTANCE = new TypeThree();
        }
        return INSTANCE;
    }
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(TypeThree.getInstance().hashCode());
            }).start();
        }
    }
}
