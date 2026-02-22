import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Thing {

    private Location location;
    private Dimensions dimensions;
    private BufferedImage image;
    private String name;

    public Thing(Location location, Dimensions dimensions, BufferedImage image,String name) {
        this.location = location;
        this.dimensions = dimensions;
        this.image = image;
        this.name = name;
    }

    public Dimensions getDimension() {
        return dimensions;
    }

    public void setDimension(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

//    public abstract Dimensions generateDimension();
//    public abstract Location generateLocation();

    public Dimensions reGenerateDimensions(String key){
        Random rand = new Random();
        if(key.equals("Tree")){
            int randomDimension = (rand.nextInt(4) + 2) * Game.UNIT_SIZE;
            return new Dimensions(randomDimension, randomDimension);
        } else if(key.equals("Rock")) {
            int randomDimension = (rand.nextInt(2) + 2) * Game.UNIT_SIZE;
            return new Dimensions(randomDimension, randomDimension);
        } else if(key.equals("Wall")){
            return new Dimensions(10*Game.UNIT_SIZE,Game.UNIT_SIZE);
        } else if(key.equals("Mountain")){
            return new Dimensions(15*Game.UNIT_SIZE,15*Game.UNIT_SIZE);
        } else if(key.equals("Bee")){
            return new Dimensions(8*Game.UNIT_SIZE,2*Game.UNIT_SIZE);
        } else if(key.equals("Bird")) {
            return new Dimensions(2*Game.UNIT_SIZE,12*Game.UNIT_SIZE);
        } else if(key.equals("Gold") || key.equals("Silver") || key.equals("Emerald") || key.equals("Copper")) {
            return new Dimensions(2*Game.UNIT_SIZE,2*Game.UNIT_SIZE);
        }//Eğer hiçbirine girmezse hatalıdır.
        return null;
    }

    public Location reLocate(String key,Dimensions dimensions){
        Random rand = new Random();
        int randomX,randomY,randomDimension;
//        if(key.equals("Tree")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Rock")) {
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Wall")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Mountain")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Bee")){
//            randomX = rand.nextInt(numberOfCols-dimensions.getWidht()/UNIT_SIZE)*UNIT_SIZE;
//            randomY = rand.nextInt(numberOfRows-dimensions.getHeight()/UNIT_SIZE)*UNIT_SIZE;
//            return new Location(randomX,randomY);
//        } else if(key.equals("Bird")) {
        randomX = rand.nextInt(Game.numberOfCols-dimensions.getWidht()/ Game.UNIT_SIZE)* Game.UNIT_SIZE;
        randomY = rand.nextInt(Game.numberOfRows-dimensions.getHeight()/ Game.UNIT_SIZE)* Game.UNIT_SIZE;
        Location location = new Location(randomX,randomY);
        return location;
//        for (int i = randomX/ Game.UNIT_SIZE; i < (randomX+dimensions.getWidht())/ Game.UNIT_SIZE; i++){
//            for (int j = randomY/ Game.UNIT_SIZE; j < (randomY+dimensions.getHeight())/ Game.UNIT_SIZE; j++){
//                if (!Game.bannedLocs.contains(location)) {
//                    Location location1 = new Location(i,j);
//                    Game.bannedLocs.add(location1);
//                    return location;
//                }
//            }
//        } return reLocate(key,dimensions);



////            if ((bannedXs.contains(randomX/UNIT_SIZE)) && (bannedYs.contains(randomY/UNIT_SIZE))){
////                generateLocation(key,dimensions);
////            }
////
////            for (int i = randomX / UNIT_SIZE; i < (randomX+dimensions.getWidht()) / UNIT_SIZE; i++) {
////                bannedXs.add(i);
////                for (int j = randomY / UNIT_SIZE; j < (randomY+dimensions.getHeight()) / UNIT_SIZE; j++) {
////                    bannedYs.add(j);
////                }
////            } return new Location(randomX, randomY);

//        }
        //Eğer hiçbirine girmezse hatalıdır.
        //return null;
    }
    public abstract void createField();
    //public abstract void printImage(Graphics g);

//    public void printImage(Graphics g) {
//        g.drawImage(getImage(), getLocation().getX(), getLocation().getY(), getImage().getWidth() / 100, getImage().getHeight() / 100, null);
//    }
}
