package abstractFactory.simple;

import abstractFactory.AbstractFactory;

public class AddFactory extends AbstractFactory {
    @Override
    public SimpleOperation createOption(Integer num1, Integer num2) {
        return new AddOperation(num1, num2);
    }
}
