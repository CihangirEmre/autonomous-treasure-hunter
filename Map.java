import javax.swing.*;
import java.awt.*;

public class Map extends JFrame{

    public Map(){
        setResizable(false);
        setFocusable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth,screenHeight);

        Game game = new Game();
        game.setFocusable(true);
        add(game);

    }
}