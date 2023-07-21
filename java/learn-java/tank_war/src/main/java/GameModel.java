import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;
    List<GameObject> objects = new ArrayList<>();
    ColliderChain colliderChain = new ColliderChain();


    public static GameModel getInstance() {
        return INSTANCE;
    }


    private GameModel() {}

    private void init() {
        myTank = new Tank(200, 500, Dir.DOWN, Group.GOOD);
        int initTankCount = PropertyManage.getInt("initTankCount");
//        初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(60 + i * 60, 200, Dir.DOWN, Group.BAD);
        }
//        初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }


    public void add(GameObject go) {
        objects.add(go);
    }

    public void remove(GameObject go) {
        objects.remove(go);
    }

    public void print(Graphics g) {
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
// 互相碰撞
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
