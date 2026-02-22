import java.awt.image.BufferedImage;

public abstract class Obstacle extends Thing {

    public Obstacle(Location location, Dimensions dimensions, BufferedImage image,String name) {
        super(location, dimensions,image,name);
    }

    public int whichSideOfTheMapAgain(Integer x){
        if (x < Game.DIVISION_WIDTH){ //Sol taraf kış temalı
            return 0; //Kış
        } else if (x > Game.DIVISION_WIDTH){ //Sağ taraf yaz temalı
            return 1; //Yaz
        } return 1; //Tam ortada ise yaz olduğunu varsayıyoruz.
    }
}
