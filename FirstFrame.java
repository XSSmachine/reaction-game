import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * FirstFrame class is used to create a JFrame that holds all the JPanels through which I can move with Cardlayout
 */

public class FirstFrame extends JPanel {

    /**
     * Here I declared the width and height of the frame and initialized each class so i can add it to the CardLayout
     */
    private static final int PREF_W = 800;
    private static final int PREF_H = 600;

    private Login login = new Login(this);
    private MainScreen main = new MainScreen(this);

    public Game1 game1 = new Game1(this);

    private Game2 game2 = new Game2(this);

    private Game3 game3 = new Game3(this);

    private Game4 game4 = new Game4(this);

    public ScoreScreen gameScore = new ScoreScreen(this);

    public CardLayout cardLayout = new CardLayout();

    public FirstFrame() {
        setLayout(cardLayout);
        add(login, Login.class.toString());
        add(main, MainScreen.class.toString());
        add(game1, Game1.class.toString());
        add(game2, Game2.class.toString());
        add(game3, Game3.class.toString());
        add(game4, Game4.class.toString());
        add(gameScore, ScoreScreen.class.toString());

    }


    /**
     * Method to swap the top card and therefore go through the jpanels
     * @param key
     */
    public void swapCards(String key) {
        cardLayout.show(this, key);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    /**
     * Here i dont quite understand why we need to initialize two frames at the same time and what does getcontentpane() do for me exactly
     */
    private static void createAndShowGui() {
        FirstFrame mainPanel = new FirstFrame();

        JFrame frame = new JFrame("FirstFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * What does this invokeLater do?
     * @param args
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

/**
 * here i understand its used to add as an argument onto the jbutton in order to use swapCards method, but i dont understand why we need mnemonic key and also this super(),
 * i read about it but cant never grasp what does it exactly does as well as this keyword.
 * +what does abstractaction do?
 */
class SwapCardAction extends AbstractAction {
    private String key;
    private FirstFrame firstFrame;

    public SwapCardAction(String name, int mnemonic, String key,
                          FirstFrame firstFrame) {
        super(name);
        this.key = key;
        this.firstFrame = firstFrame;
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        firstFrame.swapCards(key);

    }
}








