package memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;
    ArrayList fruits;
    public int getMoney(){
        return money;
    }

    public Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

   void addFruit(String fruit){
        fruits.add(fruit);
   }

    public List getFruits() {
        return (List) fruits.clone();
    }
}
