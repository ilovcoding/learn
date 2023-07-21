public class DefaultFireStrategy implements FireStrategy {
    public static DefaultFireStrategy instance = new DefaultFireStrategy();

    @Override
    public void file(Tank t) {
        int bulletX = t.x + ((Tank.WIDTH - Bullet.WIDTH) / 2);
        int bulletY = t.y + ((Tank.HEIGHT - Bullet.HEIGHT) / 2);
        new Bullet(bulletX, bulletY, t.dir, t.group);
    }
}
