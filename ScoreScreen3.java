import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ScoreScreen3 extends JPanel {

    JButton btn13;
    JButton btn23;
    JLabel label13;


    ScoreScreen3(FirstFrame firstFrame) {

        add(btn13=new JButton(new SwapCardAction("PLAY AGAIN",
                KeyEvent.VK_R, Game3.class.toString(), firstFrame)));
        add(btn23 = new JButton(new SwapCardAction("MENU",
                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));



        setBackground(Color.CYAN);

        btn13.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {




                                        remove(label13);
                                        btn13.setVisible(false);
                                        btn23.setVisible(false);



                                        remove(firstFrame.game3);
                                        remove(firstFrame.game3.textField);
                                        remove(firstFrame.game3.label3);



                                        firstFrame.description3.btn3.doClick();









                                        validate();



                                    }

                                }
        );


        btn23.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {





                                        remove(label13);
                                        btn13.setVisible(false);
                                        btn23.setVisible(false);







                                        remove(firstFrame.game3);
                                        remove(firstFrame.game3.textField);
                                        remove(firstFrame.game3.label3);




                                        validate();



                                    }

                                }
        );


    }
}
