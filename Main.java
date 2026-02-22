import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                startScreen form = new startScreen();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                System.out.println(Game.obstacles);
            }
        });
    }
}
