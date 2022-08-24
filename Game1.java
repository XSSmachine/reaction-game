import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import javax.swing.Timer;


import java.util.TimerTask;

/**
 * Here is the class of the first game where i have a problem(i dont know how to make the game restart itself from scratch(it keeps adding on jbuttons),
 * i tried to put the game into a method but i cant because some of the stuff needs to be inside a constructor and i dont know how to go around it...
 *
 *
 * The idea of the class is when its shown that first it has like a description panel where theres rules to how u play the game and also one start jbutton which leads u to the actal
 * game, which starts after 5 seconds and pops up another jbutton, when u click on it it opens up scorescreen and displays the time. Here i wanna put restart button(doesnt work)
 * and leaderboard where user can compare its best time with other players score.
 */


public class Game1 extends JPanel implements ActionListener{

    Timer timer;

    JLabel timerLabel;


    JPanel descr,game;
    JButton btn = new JButton("Start"),button1;















    Random rnd;

    public Game1(FirstFrame firstFrame) {






        StopWatch timer = new StopWatch();
        setBackground(Color.BLUE);



        JPanel descr = new JPanel();
        descr.setBounds(100,100,600,150);
        descr.setBackground(Color.BLUE);
        JLabel label = new JLabel("U ovoj igri testira se vaša brzina reakcije na način da kada dođe do promjene boje na ekranu, traži se što brži klik vašega miša.", SwingConstants.CENTER);
        descr.setForeground(Color.BLACK);
        descr.add(label);
        add(descr);





        descr.add(btn,JButton.CENTER) ;











        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                descr.setVisible(false);
                JPanel game = new JPanel();
                game.setBounds(400,300,400,300);
                JLabel label1 = new JLabel("ČEKAJ!!!");
                button1 = new JButton("KLIKNI!!!");
                button1.addActionListener(this);

                game.add(label1);
                add(game);






                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                timer.start();






                                button1.setBackground(Color.GREEN);
                                //button1 = new JButton(new SwapCardAction("KLIKNI",
                                 //       KeyEvent.VK_R, ScoreScreen.class.toString(), firstFrame));

                                game.add(button1);
                                validate();
                                repaint();

                            }
                        },
                        5000
                );
                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {

                        descr.setVisible(true);




                        //button1.removeActionListener(this);


                        timer.stop();
                        firstFrame.swapCards(ScoreScreen.class.toString());


                        firstFrame.gameScore.add(timerLabel = new JLabel("Your reaction time is: "+timer.getElapsedTime()+" ms"));
                        firstFrame.gameScore.add(new JButton(new SwapCardAction("PLAY AGAIN",
                                       KeyEvent.VK_R, Game1.class.toString(), firstFrame)));
                        firstFrame.gameScore.add(new JButton(new SwapCardAction("MENU",
                                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));





                        validate();
                        repaint();



                    }
                });


            }
});

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1) {


        }

    }
}