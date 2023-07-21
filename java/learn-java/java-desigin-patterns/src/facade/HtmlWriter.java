package facade;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

//    输出html
    public void html(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>"+title+"</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>"+title+"</h1>");
        writer.write("</body>");
        writer.write("</html>");
    }
    public void close() throws IOException {
       writer.close();
    }
}
