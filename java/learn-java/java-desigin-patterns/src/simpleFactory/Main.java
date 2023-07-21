package simpleFactory;

public class Main {
    public static void main(String[] args) {
        Operation addOperation = OperationFactory.createOperation("+",1,2);
        System.out.println(addOperation.getResult());
        Operation subOperation = OperationFactory.createOperation("-",3,4);
        System.out.println(subOperation.getResult());
    }
}
