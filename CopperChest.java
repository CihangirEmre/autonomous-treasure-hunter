import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CopperChest extends Chest{
    public CopperChest(Location location, Dimensions dimensions) {
        super(location,dimensions,null,"Copper");
        try {
            File file = new File("Rock2.png"); // Dosya yolunu doğru şekilde ayarlayın
            if (!file.exists()) {
                throw new FileNotFoundException("CopperChest.png dosyası bulunamadı");
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
