import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GoldChest extends Chest{
    public GoldChest(Location location, Dimensions dimensions) {
        super(location,dimensions,null,"Gold");
        try {
            File file = new File("WorldCup.png"); // Dosya yolunu doğru şekilde ayarlayın
            if (!file.exists()) {
                throw new FileNotFoundException("WorldCup.png dosyası bulunamadı");
            }
            setImage(ImageIO.read(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createField();
    }

//    @Override
//    public void printImage(Graphics g) {
//
//    }
}
