package state;

public class Main {
    public static void main(String[] args) {
        StateFrame frame = new StateFrame();
        for (int i = 0; i < 24; i++) {
            frame.setClock(i);
            frame.use();
        }
    }
}
