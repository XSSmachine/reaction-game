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

    public Login login = new Login(this);
    public MainScreen main = new MainScreen(this);


    public Game1Description description1 = new Game1Description(this);
    public Game1 game1 = new Game1(this);
    public ScoreScreen1 gameScore = new ScoreScreen1(this);


    public Game2Description description2 = new Game2Description(this);
    public Game2 game2 = new Game2(this);
    public ScoreScreen2 gameScore2 = new ScoreScreen2(this);

    public Game3Description description3 = new Game3Description(this);
    public Game3 game3 = new Game3(this);
    public ScoreScreen3 gameScore3 = new ScoreScreen3(this);

    public Game4Description description4 = new Game4Description(this);
    public Game4 game4 = new Game4(this);
    public ScoreScreen4 gameScore4 = new ScoreScreen4(this);

    public Stats stats = new Stats(this);

    TableGame1 tgame1 = new TableGame1(this);
    TableGame2 tgame2 = new TableGame2(this);





    public CardLayout cardLayout = new CardLayout();

    public FirstFrame() {
        setLayout(cardLayout);
        add(login, Login.class.toString());
        add(main, MainScreen.class.toString());

        add(description1, Game1Description.class.toString());
        add(game1, Game1.class.toString());
        add(gameScore, ScoreScreen1.class.toString());

        add(description2, Game2Description.class.toString());
        add(game2, Game2.class.toString());
        add(gameScore2, ScoreScreen2.class.toString());

        add(description3, Game3Description.class.toString());
        add(game3, Game3.class.toString());
        add(gameScore3, ScoreScreen3.class.toString());

        add(description4, Game4Description.class.toString());
        add(game4, Game4.class.toString());
        add(gameScore4, ScoreScreen4.class.toString());

        add(stats, Stats.class.toString());
        add(tgame1, TableGame1.class.toString());
        add(tgame2, TableGame2.class.toString());






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








