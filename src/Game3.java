import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game3 extends JPanel {

    JTextField textField = new JTextField();

    String passage="";

    JLabel label3 = new JLabel();

    OuterClass counterr = new OuterClass();

    StopWatch timer3 = new StopWatch();
    public Game3(FirstFrame firstFrame) {
        firstFrame.description3.btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                

                setLayout(null);
                passage = getText();


                label3 = new JLabel(passage);
                label3.setBounds(300,50,200,100);
                add(label3);

                Dimension size = counterr.secondsLabel.getPreferredSize();
                counterr.secondsLabel.setBounds(400, 200,
                        size.width + 200, size.height + 150);

                counterr.secondsLabel.setBackground(Color.red);
                add(counterr.secondsLabel);
                counterr.setupTimer(3);

                textField = new JTextField(60);
                textField.setBounds(200,400,400,100);
                textField.setFont(new Font("Consolas", Font.PLAIN, 35));
                textField.setForeground(new Color(0x00FF00));
                textField.setBackground(Color.black);
                textField.setCaretColor(Color.white);
                textField.setEditable(false);
                textField.requestFocus(true);
                add(textField);


                setVisible(true);

                validate();



                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                remove(counterr.secondsLabel);
                                timer3.start();
                                textField.setEditable(true);



                                validate();
                                repaint();




                                textField.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if(label3.getText().equals(textField.getText())) {

                                            remove(label3);
                                            remove(textField);
                                            setVisible(false);
                                            timer3.stop();
                                            firstFrame.gameScore3.add(firstFrame.gameScore3.label13 = new JLabel("Your approximate type speed: " + (int)(1/(((double)timer3.getElapsedTime())/60000)) + "wpm"));
                                            firstFrame.gameScore3.btn13.setVisible(true);
                                            firstFrame.gameScore3.btn23.setVisible(true);
                                            firstFrame.swapCards(ScoreScreen3.class.toString());

                                            try{
                                                FileWriter fileWriter = new FileWriter(String.format("./players/%s/"+"game3.csv",firstFrame.login.ime1),true);
                                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                                                printWriter.println((int)(1/(((double)timer3.getElapsedTime())/60000)));
                                                printWriter.flush();
                                                printWriter.close();
                                            }catch(Exception eaa){
                                                eaa.printStackTrace();

                                            }


                                            validate();
                                            repaint();


                                        }
                                    }
                                });















                            }


                        },
                        0

                );

            }
        });



    }

    public String getText() {

        ArrayList<String> list = new ArrayList<String>();
        String pas1 = "Prefix";
        String pas2 = "Polymorph"; ;
        String pas3 = "Inherit";
        String pas4 = "Parent";
        String pas5 = "Action";
        String pas6 = "Java";
        String pas7 = "Faster";
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
