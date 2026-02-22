import org.xml.sax.helpers.LocatorImpl;

import java.awt.image.BufferedImage;

public abstract class DynamicObstacle extends Obstacle{
    public DynamicObstacle(Location location, Dimensions dimensions, BufferedImage image,String name) {
        super(location, dimensions,image,name);
    }

    public void createField() {
        int firstX = getLocation().getX()/Game.UNIT_SIZE;
        int diffX = getDimension().getWidht()/Game.UNIT_SIZE;
        int firstY = getLocation().getY()/Game.UNIT_SIZE;
        int diffY = getDimension().getHeight()/Game.UNIT_SIZE;
        for(int i = 0; i < diffX; i++){ //Engelin x uzunluğu kadar döner
            for(int j = 0; j < diffY; j++){ //Engelin y uzunluğu kadar döner
                int cellValue = Game.mapMatrix[firstX + i][firstY + j];
                if (cellValue != 0){
                    Dimensions dimensions = reGenerateDimensions(this.getName());
                    Location location = reLocate(this.getName(),dimensions);
                    setLocation(location);
                    createField();
                    return;
                }
            }
        }
        for(int i = 0; i < diffX; i++) { //Engelin x uzunluğu kadar döner
            for (int j = 0; j < diffY; j++) { //Engelin y uzunluğu kadar döner
                Game.mapMatrix[firstX + i][firstY + j] = 2; //Engelin ilk (x,y) değerinde son (x,y), değerine kadar
                // olan bölgeyi kapsayan alanı 1 ile doldurur.
            }
        }
    }
}
