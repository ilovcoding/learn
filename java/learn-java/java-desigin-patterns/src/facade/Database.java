package facade;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database(){}
    public  static Properties getProperties(String dbname){
        String filename = dbname + ".properties";
        Properties prop = new Properties();
        try {
            prop.load(Database.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e){
            System.out.println("Warning: "+filename+" is not found");
            e.printStackTrace();
        }
        return prop;
    }
}
