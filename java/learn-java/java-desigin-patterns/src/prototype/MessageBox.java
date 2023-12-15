package prototype;

public class MessageBox  implements Product<MessageBox>{
    public  String name = "MessageBox";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void use() {
        System.out.println(name + " use method");
    }

    @Override
    public MessageBox createClone() {
        MessageBox p = null;
        try {
            p = (MessageBox) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  p;
    }
}
