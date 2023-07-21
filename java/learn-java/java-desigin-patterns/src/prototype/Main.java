package prototype;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Product<MessageBox> messageBox = new MessageBox();
        manager.register("messageBox",messageBox);
        MessageBox product = manager.create("messageBox");
        MessageBox product1 = manager.create("messageBox");
        product.setName("product");
        product1.setName("product1");
        product.use();
        product1.use();
    }
}
