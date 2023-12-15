package factoryMethod;

public class AddFactory implements OperationFactory {

    @Override
    public Operation createOperation(Integer num1, Integer num2) {
        return new AddOperation(num1, num2);
    }
}
