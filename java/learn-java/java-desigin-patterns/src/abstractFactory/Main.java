package abstractFactory;

import abstractFactory.science.ScienceOperation;
import abstractFactory.simple.SimpleOperation;

public class Main {
    public static void main(String[] args) {
        AbstractFactory simpleFactory = FactoryProducer.getFactory("simple");
        SimpleOperation simpleOperation =  simpleFactory.createOption(1,1);
        System.out.println(simpleOperation.getResult());
        AbstractFactory scienceFactory = FactoryProducer.getFactory("science");
        ScienceOperation scienceOperation = scienceFactory.createOperation(1.1,1.1);
        System.out.println(scienceOperation.getResult());
    }
}
