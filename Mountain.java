import java.util.Random;

public abstract class Mountain extends StaticObstacle {

    public Mountain(Location location, Dimensions dimensions) {
        super(location,dimensions,null,"Mountain");
//        setDimension(generateDimension());
//        setLocation(generateLocation());
        createField();
//        int control = whichSideOfTheMapAgain(this.getLocation().getX()); // 0 = Kış, 1 = Yaz
//
//        if (control == 0 && this instanceof SummerMountain){ // Yanlış
//            WinterMountain winterMountain = (WinterMountain) this;
//        } else if (control == 1 && this instanceof WinterMountain){ // Yanlış
//            WinterMountain winterMountain = (WinterMountain) this;
//        }
    }

//    @Override
//    public Dimensions generateDimension() {
//        return new Dimensions(15*Game.UNIT_SIZE,15*Game.UNIT_SIZE);
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
