public class BulletTankCollider implements  Collider {
    private boolean collideWidth(Tank tank,Bullet bullet) {
        if(tank.getGroup() == Group.GOOD){
            return true;
        }
        if(bullet.getGroup() == tank.getGroup()){
            return true;
        }
        if(bullet.rectangle.intersects(tank.rectangle)){
//            坦克和子弹两个矩形存在交集
            tank.die();
            bullet.die();
            return false;
        }
        return true;
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
           return collideWidth(t, b);
        }else if(o1 instanceof Tank && o2 instanceof  Bullet){
            return collide(o2, o1);
        }else {
            return true;
        }
    }
}
