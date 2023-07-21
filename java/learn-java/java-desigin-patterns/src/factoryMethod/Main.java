package factoryMethod;

public class Main {
    public static void main(String[] args) {
        Operation add = new AddFactory().createOperation(1,2);
        System.out.println(add.getResult());
        Operation sub = new SubFactory().createOperation(3,4);
        System.out.println(sub.getResult());
    }
}