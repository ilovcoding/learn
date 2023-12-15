package factoryMethod;

public class SubFactory implements OperationFactory {
    @Override
    public Operation createOperation(Integer num1, Integer num2) {
        return new SubOperation(num1,num2);
    }
}
