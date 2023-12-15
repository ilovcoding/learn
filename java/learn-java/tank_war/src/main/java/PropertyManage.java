import java.io.IOException;
import java.util.Properties;

public class PropertyManage {
    private PropertyManage() {
    }

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyManage.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        return props.get(key);
    }

    public static String getString(String key) {
        return (String) get(key);
    }

    public static Integer getInt(String key) {
        return Integer.parseInt((String) get(key));
    }
}
