import java.awt.*;

public class Bullet extends GameObject{
    private int x,y;
    private Dir dir;
    private  boolean living = true;
    private GameModel gm = GameModel.getInstance();
    private static final int SPEED = 10;
    private  Group group = Group.BAD;
    public static final int WIDTH=ResourceManage.bulletU.getWidth();
    public static final int HEIGHT=ResourceManage.bulletU.getHeight();
    public Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        gm.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if(!living){
            gm.remove(this);
        }
        switch (dir){
            case UP:
                g.drawImage(ResourceManage.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManage.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManage.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManage.bulletL, x, y, null);
                break;
        }
        move();
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        rectangle.x = x;
        rectangle.y = y;
        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            living = false;
        }
    }

    public void die() {
        living = false;
    }
}
