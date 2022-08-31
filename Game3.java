import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game3 extends JPanel {

    JTextField textField = new JTextField();

    String passage="";

    JLabel label3 = new JLabel();

    OuterClass counterr = new OuterClass();

    String[] words,words1;

    StopWatch timer3 = new StopWatch();
    public Game3(FirstFrame firstFrame) {
        firstFrame.description3.btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                

                setLayout(new GridLayout(2,2));
                passage = getText();


                label3 = new JLabel(passage);
                add(label3);

                Dimension size = counterr.secondsLabel.getPreferredSize();
                counterr.secondsLabel.setBounds(400, 200,
                        size.width + 200, size.height + 150);

                counterr.secondsLabel.setBackground(Color.red);
                add(counterr.secondsLabel);
                counterr.setupTimer(3);


                setVisible(true);

                validate();



                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                remove(counterr.secondsLabel);
                                timer3.start();


                                textField = new JTextField();
                                textField.setPreferredSize(new Dimension(250, 40));
                                textField.setFont(new Font("Consolas", Font.PLAIN, 35));
                                textField.setForeground(new Color(0x00FF00));
                                textField.setBackground(Color.black);
                                textField.setCaretColor(Color.white);
                                add(textField);
                                validate();




                                textField.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if(label3.getText().equals(textField.getText())) {

                                            remove(label3);
                                            remove(textField);
                                            timer3.stop();
                                            firstFrame.gameScore3.add(firstFrame.gameScore3.label13 = new JLabel("Your reaction time: " + timer3.getElapsedTime() + "ms"));
                                            firstFrame.swapCards(ScoreScreen3.class.toString());
                                            validate();
                                            repaint();


                                        }
                                    }
                                });















                            }


                        },
                        5000

                );

            }
        });



    }

    public String getText() {

        ArrayList<String> list = new ArrayList<String>();
        String pas1 = "Encapsulation";
        String pas2 = "Polymorphism"; ;
        String pas3 = "Inheritance";
        String pas4 = "Parenthesization";
        String pas5 = "ActionEvent";
        String pas6 = "JavaSwing";
        String pas7 = "Fasterrr";
        String pas8 = "Object";
        String pas9 = "Class";
        String pas10 = "Method";
        list.add(pas1);
        list.add(pas2);
        list.add(pas3);
        list.add(pas4);
        list.add(pas5);
        list.add(pas6);
        list.add(pas7);
        list.add(pas8);
        list.add(pas9);
        list.add(pas10);

        Random rand=new Random();
        int place=(rand.nextInt(10));

        String toReturn=list.get(place);

        return(toReturn);
    }






}
