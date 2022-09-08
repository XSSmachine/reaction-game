import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Game4 extends JPanel {

    JLabel label,label1;

    JButton button;

    public int count = 0;

    OuterClass out = new OuterClass();

    public Game4(FirstFrame firstFrame) {
        firstFrame.description4.btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Dimension size = out.secondsLabel.getPreferredSize();
                out.secondsLabel.setBounds(400, 200,
                        size.width + 200, size.height + 150);

                out.secondsLabel.setBackground(Color.red);
                add(out.secondsLabel);
                out.setupTimer(3);


                new java.util.Timer().schedule(

                        new java.util.TimerTask() {
                            @Override
                            public void run() {


                                button = new JButton("Klikni me!");


                                label = new JLabel("Broj klikova: 0");
                                label1 = new JLabel("BROJ KLIKOVA U 5 SEKUNDI");

                                remove(out.secondsLabel);
                                add(button);
                                add(label);
                                add(label1);

                                validate();
                                repaint();


                                button.addActionListener(new ActionListener() {

                                    public void actionPerformed(ActionEvent e) {

                                        count++;

                                        label.setText("Broj klikova: " + count);






                                    }





                                });
                                new java.util.Timer().schedule(
                                        new java.util.TimerTask() {
                                            @Override
                                            public void run() {
                                                setBackground(Color.YELLOW);
                                                remove(label);
                                                remove(label1);
                                                remove(button);
                                                setVisible(false);

                                                firstFrame.gameScore4.add(firstFrame.gameScore4.label14 = new JLabel("Vaš broj klikova u 5 sekundi: " + count));
                                                firstFrame.gameScore4.btn14.setVisible(true);
                                                firstFrame.gameScore4.btn24.setVisible(true);
                                                firstFrame.swapCards(ScoreScreen4.class.toString());

                                                try {
                                                    FileWriter fileWriter = new FileWriter(String.format("./players/%s/"+"game4.csv",firstFrame.login.ime1), true);
                                                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                                                    printWriter.println(count);
                                                    printWriter.flush();
                                                    printWriter.close();
                                                } catch (Exception eaaa) {
                                                    eaaa.printStackTrace();

                                                }
                                                count=0;


                                                validate();
                                                repaint();


                                            }
                                        },
                                        4000
                                );






                            }
                        },
                        4000
                );

                
                
            }
        });
        
        
    }


}
