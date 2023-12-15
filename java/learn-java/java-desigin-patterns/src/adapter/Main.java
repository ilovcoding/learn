package adapter;

public class Main {
    public static void main(String[] args) {
        Print pStr = new PrintBanner(new Banner("Hello World"));
        pStr.printWidthParen();
        pStr.printWidthAster();
    }
}
