package flyweight;

import java.util.HashMap;

public class NumberFactory {
    private HashMap numPoll = new HashMap();
    private static NumberFactory numberFactory = new NumberFactory();
    private NumberFactory(){};

    public static NumberFactory getInstance() {
        return numberFactory;
    }
    public synchronized Number getNumber(char num){
        Number number = (Number) numPoll.get(num);
        if(number == null){
            number = new Number(num);
            numPoll.put(num,number);
        }
        return number;
    }
}
