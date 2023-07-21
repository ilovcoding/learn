package netty.api_reactor.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileIo {

    public static void read() throws IOException {
        File file = new File("E:\\java\\maven-hello-world\\src\\main\\java\\netty_code_analysis\\io\\hello.txt");
        // 模板方法模式 https://github.com/iluwatar/java-design-patterns/tree/master/template-method
        // 底层实际上是调用了 操作系统的 read 函数，可以参考 c 语言的 read 文件的实现。
        FileInputStream fileInputStream = new FileInputStream(file);
        char readOne = (char) fileInputStream.read();
        System.out.println(readOne);
    }

    public static void readFile() throws IOException {
        File file = new File("E:\\java\\maven-hello-world\\src\\main\\java\\netty_code_analysis\\io\\hello.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int read = fileInputStream.read(bytes, 0, bytes.length);
        System.out.println(new String(bytes).trim());
    }

    public static void readFileByChannel() throws IOException {
        File file = new File("E:\\java\\maven-hello-world\\src\\main\\java\\netty_code_analysis\\io\\hello.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        // 调用 flip 之后 不需要 上一步(readFile)一样 trim str.
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        System.out.println(new String(bytes, Charset.forName("UTF-8")));
    }

    public static void main(String[] args) throws IOException {
        read();
        readFile();
        readFileByChannel();
    }
}
