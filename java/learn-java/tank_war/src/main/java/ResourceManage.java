import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManage {
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];


    static {
        try {
            goodTankU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
            goodTankL = ImageUtil.rotateImage(goodTankU, 270);

            badTankU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            badTankL = ImageUtil.rotateImage(badTankU, 270);

            bulletU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, 270);

            for (int i = 0; i < 16; i++)
                explodes[i] = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
