import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WinterWall extends Wall  implements IWinterObstacle{

    private BufferedImage image;

    public WinterWall(Location location, Dimensions dimensions) throws IOException {
        super(location,dimensions);
        try {
            File file = new File("WinterWall.png"); // Dosya yolunu doğru şekilde ayarlayın
            if (!file.exists()) {
                throw new FileNotFoundException("WinterWall.png dosyası bulunamadı");
            }
            setImage(ImageIO.read(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void printImage(Graphics g) {
//        g.drawImage(getImage(), getLocation().getX(), getLocation().getY(), getImage().getWidth() / 100, getImage().getHeight() / 100, null);
//    }
}
