import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Bird extends DynamicObstacle {
    public Bird(Location location, Dimensions dimensions) {
        super(location,dimensions,null,"Bird");
//        setDimension(generateDimension());
//        setLocation(generateLocation());

        try {
            setImage(ImageIO.read(new FileImageInputStream(new File("Bird3.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createField();
        Game.birdLocs.add(getLocation());
        //printImage();
    }

//    @Override
//    public Dimensions generateDimension() {
//        return new Dimensions(2*Game.UNIT_SIZE,9*Game.UNIT_SIZE);
//    }
//
//    @Override
//    public Location generateLocation() {
//        Random rand = new Random();
//        int randomX = rand.nextInt(Game.numberOfCols-getDimension().getWidht()/Game.UNIT_SIZE)*Game.UNIT_SIZE;
//        int randomY = rand.nextInt(Game.numberOfRows-getDimension().getHeight()/Game.UNIT_SIZE)*Game.UNIT_SIZE;
//        return new Location(randomX,randomY);
//    }

//    @Override
//    public void printImage(Graphics g) {
//        g.drawImage(getImage(), getLocation().getX(), getLocation().getY(), getImage().getWidth() / 100, getImage().getHeight() / 100, null);
//    }
}
