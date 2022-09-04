import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * This class holds the referance jbuttons to all 4 games and also has a button for logout and to see statistics
 * (I planned to show statistics in tables from csv files and also have them look at average score and min/max times of each ga
 */
public class MainScreen extends JPanel {



    private JButton Game1;
    private JButton game2Button;
    private JButton game4Button;
    private JButton game3Button;
    public JButton STATSButton;
    private JButton LOGOUTButton;

    public MainScreen(final FirstFrame firstFrame) {

        JButton Game1 = new JButton(new SwapCardAction("Game1",
                KeyEvent.VK_R, Game1Description.class.toString(), firstFrame));

        JButton game2Button = new JButton(new SwapCardAction("Game2",
                KeyEvent.VK_R, Game2Description.class.toString(), firstFrame));

        JButton game3Button = new JButton(new SwapCardAction("Game3",
                KeyEvent.VK_R, Game3Description.class.toString(), firstFrame));

        JButton game4Button = new JButton(new SwapCardAction("Game4",
                KeyEvent.VK_R, Game4Description.class.toString(), firstFrame));

        JButton LOGOUTButton = new JButton(new SwapCardAction("LOGOUT",
                KeyEvent.VK_R, Login.class.toString(), firstFrame));

        JButton STATSButton = new JButton(new SwapCardAction("STATS",
                KeyEvent.VK_R, Stats.class.toString(), firstFrame));

        STATSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });


        add(Game1);
        add(game2Button);
        add(game3Button);
        add(game4Button);
        add(LOGOUTButton);
        add(STATSButton);



    }


}
