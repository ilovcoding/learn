import java.awt.*;

public class Explode extends GameObject {
    public  static  int WIDTH = ResourceManage.explodes[0].getWidth();
    public static  int HEIGHT = ResourceManage.explodes[0].getHeight();
    private int x, y;
    private boolean living = true;
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
//       new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(ResourceManage.explodes[step++],x,y,null);
        if (step >= ResourceManage.explodes.length){
//            step = 0;
            GameModel.getInstance().remove(this);
        }
    }
}
