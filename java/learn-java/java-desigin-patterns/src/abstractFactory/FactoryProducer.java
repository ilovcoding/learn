package abstractFactory;

import abstractFactory.science.ScienceAddFactory;
import abstractFactory.simple.AddFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        switch (choice)
        {
            case "simple":
                return new AddFactory();
            case "science":
                return new ScienceAddFactory();
        }
        return null;
    }
}
