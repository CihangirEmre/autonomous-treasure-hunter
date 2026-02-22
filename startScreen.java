import javax.swing.*;
import java.awt.event.*;

public class startScreen extends JFrame{

    private JButton showMapButton;
    private JButton startButton;
    private JPanel startPanel;
    private JLabel label;

    public startScreen(){
        add(startPanel);
        setSize(500,500);

        showMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map mapScreen = new Map();
                mapScreen.setVisible(true);
                mapScreen.setLocationRelativeTo(null);
            }
        });

    }
}
