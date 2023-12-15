import java.util.HashMap;
import java.util.Map;

public class TankTankCollider implements Collider {
    private Map<Dir, Dir> reverseDirMap = new HashMap<>() {{
        put(Dir.UP, Dir.DOWN);
        put(Dir.RIGHT, Dir.LEFT);
        put(Dir.DOWN, Dir.UP);
        put(Dir.LEFT, Dir.RIGHT);
    }};

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
//            TODO 发现碰撞之后反向游戏效果也不是很好，暂不处理坦克互相碰撞的事件
//          两个坦克矩形存在相交。
//            if (t1.rectangle.intersects(t2.rectangle)) {
////                两个坦克碰撞后直接反向
//                t1.setDir(reverseDirMap.get(t1.dir));
//                t2.setDir(reverseDirMap.get(t2.dir));
//            }
        }
        return true;
    }
}
