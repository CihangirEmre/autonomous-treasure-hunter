import java.util.Random;

public abstract class Wall extends StaticObstacle {
    public Wall(Location location, Dimensions dimensions) {
        super(location, dimensions,null,"Wall");
//        setDimension(generateDimension());
//        setLocation(generateLocation());
        createField();
//        int control = whichSideOfTheMapAgain(this.getLocation().getX()); // 0 = Kış, 1 = Yaz
//
//        if (control == 0 && this instanceof SummerWall){ // Yanlış
//            WinterWall winterWall = (WinterWall) this;
//        } else if (control == 1 && this instanceof WinterWall){ // Yanlış
//            SummerWall summerWall = (SummerWall) this;
//        }
    }

//    @Override
//    public Dimensions generateDimension() {
//        return new Dimensions(10*Game.UNIT_SIZE,Game.UNIT_SIZE);
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
//    public abstract void printImage();
}
