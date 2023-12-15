package prototype;

import java.util.HashMap;

public class Manager {
    private HashMap showcase = new HashMap();
    public <T> void  register(String name, Product<T> product){
        showcase.put(name,product);
    }
    public <T> T create(String productName){
        Product<T> p = (Product) showcase.get(productName);
        return p.createClone();
    }
}
