package abstractFactory.science;


import abstractFactory.AbstractFactory;

public class ScienceAddFactory extends AbstractFactory {
    @Override
    public ScienceOperation createOperation(Double num1, Double num2) {
        return new AddScienceOperation(num1, num2);
    }
}
