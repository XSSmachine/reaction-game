import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * here i will make a different type of the game, but i need to get set with first game in order to being able to implement other games.
 */
public class Game2 extends JPanel {

    JPanel game2;
    public JButton button12 = new JButton();
    public JButton button22 = new JButton();
    public JButton button32 = new JButton();

    OuterClass counter = new OuterClass();
  

    public Game2(FirstFrame firstFrame) {




        StopWatch timer2 = new StopWatch();


        firstFrame.description2.btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                setLayout(null);
                setPreferredSize(new Dimension(800, 600));
                Insets insets = getInsets();
                Dimension size = counter.secondsLabel.getPreferredSize();
                counter.secondsLabel.setBounds(400, 200,
                        size.width + 200, size.height + 150);

                counter.secondsLabel.setBackground(Color.red);
                add(counter.secondsLabel);
                counter.setupTimer(3);


                setVisible(true);

                validate();
                repaint();


                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {

                                timer2.start();
                                remove(counter.secondsLabel);


                                Dimension size = button12.getPreferredSize();
                                button12.setBounds((int) (Math.random() * (700 - 100)) + 100, (int) (Math.random() * (500 - 100)) + 100,
                                        size.width + 100, size.height + 50);

                                button12.setBackground(Color.green);
                                add(button12);

                                validate();
                                repaint();
                            }
                        },
                        4000
                );
            }
            });


                button12.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        remove(button12);


                        Dimension size = button22.getPreferredSize();
                        button22.setBounds((int) (Math.random() * (700 - 100)) + 100, (int) (Math.random() * (500 - 100)) + 100,
                                size.width + 70, size.height + 30);


                        button22.setBackground(Color.green);
                        add(button22);

                        validate();
                        repaint();
                    }
                });

                button22.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        remove(button22);


                        Dimension size = button32.getPreferredSize();
                        button32.setBounds((int) (Math.random() * (700 - 100)) + 100, (int) (Math.random() * (500 - 100)) + 100, size.width + 50, size.height + 30);

                        button32.setBackground(Color.green);
                        add(button32);

                        validate();
                        repaint();
                    }
                });

                button32.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {


                        remove(button32);

                        setVisible(false);


                        //firstFrame.gameScore.btn1.setVisible(true);
                        //firstFrame.gameScore.btn2.setVisible(true);


                        timer2.stop();


                        firstFrame.gameScore2.add(firstFrame.gameScore2.label1 = new JLabel("Your reaction time: " + timer2.getElapsedTime() + "ms"));
                        firstFrame.gameScore2.btn12.setVisible(true);
                        firstFrame.gameScore2.btn22.setVisible(true);


                        firstFrame.swapCards(ScoreScreen2.class.toString());

                        try{
                            FileWriter fileWriter = new FileWriter(String.format("C:/%s/"+"game2.csv",firstFrame.login.ime1),true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);

                            printWriter.println(timer2.getElapsedTime());
                            printWriter.flush();
                            printWriter.close();
                        }catch(Exception ea){
                            ea.printStackTrace();

                        }


                        validate();
                        repaint();


                    }
                });


                //button12.setBackground(Color.GREEN);
                //button12 = new JButton(new SwapCardAction("KLIKNI",
                //       KeyEvent.VK_R, ScoreScreen.class.toString(), firstFrame));

                //game2.add(button12);



            }


        }


