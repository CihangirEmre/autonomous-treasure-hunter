import java.util.Random;

public abstract class Tree extends StaticObstacle {
    public Tree(Location location, Dimensions dimensions) {
        super(location, dimensions,null,"Tree");
//        setDimension(generateDimension());
//        setLocation(generateLocation());
        createField();
//        int control = whichSideOfTheMapAgain(this.getLocation().getX()); // 0 = Kış, 1 = Yaz
//
//        if (control == 0 && this instanceof SummerTree){ // Yanlış
//            WinterTree winterTree = (WinterTree) this;
//        } else if (control == 1 && this instanceof WinterTree){ // Yanlış
//            SummerTree summerTree = (SummerTree) this;
//        }
    }

//    public Dimensions generateDimension() {
//        Random random = new Random();
//        int randomDimension = (random.nextInt(4) + 2) * Game.UNIT_SIZE;
//        return new Dimensions(randomDimension, randomDimension);
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
