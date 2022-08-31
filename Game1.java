import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Here is the class of the first game where i have a problem(i dont know how to make the game restart itself from scratch(it keeps adding on jbuttons),
 * i tried to put the game into a method but i cant because some of the stuff needs to be inside a constructor and i dont know how to go around it...
 *
 *
 * The idea of the class is when its shown that first it has like a description panel where theres rules to how u play the game and also one start jbutton which leads u to the actal
 * game, which starts after 5 seconds and pops up another jbutton, when u click on it it opens up scorescreen and displays the time. Here i wanna put restart button(doesnt work)
 * and leaderboard where user can compare its best time with other players score.
 */


public class Game1 extends JPanel {







    JButton btn = new JButton("Start"),button1,label1;;



    public Game1(FirstFrame firstFrame) {



        firstFrame.description1.btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StopWatch timer = new StopWatch();



                setLayout(new BorderLayout());
                label1 = new JButton("ČEKAJ!!!");
                button1 = new JButton("KLIKNI!!!");
                label1.setBackground(Color.red);
                add(label1,BorderLayout.CENTER);
                label1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==label1) {

                            //firstFrame.gameScore.add(firstFrame.gameScore.label = new JLabel("Prerano ste kliknuli!!!"));
                            //firstFrame.swapCards(ScoreScreen.class.toString());

                            validate();

                        }



                    }
                    });



                new java.util.Timer().schedule(

                        new java.util.TimerTask() {
                            @Override
                            public void run() {

                                    timer.start();
                                    remove(label1);
                                    button1.setBackground(Color.GREEN);
                                    add(button1,BorderLayout.CENTER);
                                    validate();






                            }
                        },
                        5000
                );

                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {


                        remove(button1);
                        remove(label1);




                        //firstFrame.gameScore.btn1.setVisible(true);
                        //firstFrame.gameScore.btn2.setVisible(true);
                        timer.stop();
                        firstFrame.gameScore.add(firstFrame.gameScore.label=new JLabel("Your reaction time: "+timer.getElapsedTime()+"ms"));
                        firstFrame.swapCards(ScoreScreen1.class.toString());

                        try{
                            FileWriter fileWriter = new FileWriter(String.format("C:/%s/"+"game1.csv",firstFrame.login.ime1),true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);

                            printWriter.println(timer.getElapsedTime());
                            printWriter.flush();
                            printWriter.close();
                        }catch(Exception e){
                            e.printStackTrace();

                        }

                        validate();





                    }
                });


            }
});

    }



}