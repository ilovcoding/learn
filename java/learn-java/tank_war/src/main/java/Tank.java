import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    int x, y;
    private Random random = new Random();
    private boolean living = true;
    Dir dir = Dir.DOWN;
    private boolean moving = true;
    private static final int SPEED = 5;
    Group group = Group.BAD;
    public static final int WIDTH = ResourceManage.goodTankU.getWidth();
    public static final int HEIGHT = ResourceManage.goodTankU.getHeight();
    public Rectangle rectangle = new Rectangle();
    GameModel gm = GameModel.getInstance();

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rectangle.x = x;
        rectangle.y = y;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void paint(Graphics g) {
        if(!living){
            gm.remove(this);
            int explodeX = this.x + WIDTH/2-Explode.WIDTH/2;
            int explodeY = this.y + HEIGHT/2 - Explode.HEIGHT/2;
            gm.add(new Explode(explodeX,explodeY));
            return;
        }
        switch (dir) {
            case UP:
                g.drawImage(this.group == Group.GOOD?ResourceManage.goodTankU:ResourceManage.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD? ResourceManage.goodTankR:ResourceManage.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD?ResourceManage.goodTankD:ResourceManage.badTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD?ResourceManage.goodTankL:ResourceManage.badTankL, x, y, null);
                break;
        }
//        TODO 测试代码
//        System.out.println("x_" + x + "y_" + y);
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
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
        if(this.group == Group.BAD && random.nextInt(100)>90){
            this.fire(DefaultFireStrategy.instance);
        }
        randomDir();
        boundsCheck();
        rectangle.x = x;
        rectangle.y = y;
    }

    private void boundsCheck() {
        if(this.x<WIDTH)x=WIDTH;
        if(this.y<HEIGHT)y=HEIGHT;
        if(this.x>(TankFrame.GAME_WIDTH-WIDTH*2)) x = TankFrame.GAME_HEIGHT - WIDTH*2;
        if(this.y>(TankFrame.GAME_HEIGHT-HEIGHT*2)) y = TankFrame.GAME_HEIGHT - HEIGHT*2;
    }

    private void randomDir() {
        if(this.group == Group.GOOD || random.nextInt(100)<90){
            return;
        }
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStrategy fireStrategy) {
        fireStrategy.file(this);
    }

    public void die() {
        living = false;
    }
    public void stop(){
        moving = false;
    }
}
