package facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker(){

    }
    public static void makeWelcomePage(String email, String filename){
        try {
            Properties mailProps = Database.getProperties("maildata");
            String username = mailProps.getProperty(email);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.html(username);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
