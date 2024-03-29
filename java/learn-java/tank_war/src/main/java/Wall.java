import java.awt.*;

public class Wall extends GameObject {
    int w, h;
    public Rectangle rectangle;

    public Wall(int x, int y, int w, int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.rectangle = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }
}
