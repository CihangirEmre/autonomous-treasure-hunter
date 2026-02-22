import java.awt.image.BufferedImage;

public abstract class StaticObstacle extends Obstacle{
    public StaticObstacle(Location location, Dimensions dimensions, BufferedImage image,String name) {
        super(location, dimensions,image,name);
    }

    public void createField() {
        int firstX = getLocation().getX()/Game.UNIT_SIZE;
        int diffX = getDimension().getWidht()/Game.UNIT_SIZE;
        int firstY = getLocation().getY()/Game.UNIT_SIZE;
        int diffY = getDimension().getHeight()/Game.UNIT_SIZE;
        int control = whichSideOfTheMapAgain(this.getLocation().getX()); // 0 = Kış, 1 = Yaz
        for(int i = 0; i < diffX; i++){ //Engelin x uzunluğu kadar döner
            for(int j = 0; j < diffY; j++){ //Engelin y uzunluğu kadar döner
                int cellValue = Game.mapMatrix[firstX + i][firstY + j];
                if (cellValue != 0 || (control == 0 && this instanceof ISummerObstacle) || (control == 1 && this instanceof IWinterObstacle)){
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
                Game.mapMatrix[firstX + i][firstY + j] = 1; //Engelin ilk (x,y) değerinde son (x,y), değerine kadar
                // olan bölgeyi kapsayan alanı 1 ile doldurur.
            }
        }
    }
}
