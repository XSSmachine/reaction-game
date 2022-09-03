import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ScoreScreen4 extends JPanel{
    JButton btn14;
    JButton btn24;
    JLabel label14;
    ScoreScreen4(FirstFrame firstFrame){





            add(btn14=new JButton(new SwapCardAction("PLAY AGAIN",
                    KeyEvent.VK_R, Game4.class.toString(), firstFrame)));
            add(btn24 = new JButton(new SwapCardAction("MENU",
                    KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));



            setBackground(Color.CYAN);

            btn14.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent event) {




                                            remove(label14);
                                            btn14.setVisible(false);
                                            btn24.setVisible(false);



                                            remove(firstFrame.game4);
                                            remove(firstFrame.game4.label);
                                            remove(firstFrame.game4.label1);
                                            remove(firstFrame.game4.button);



                                            firstFrame.description4.btn4.doClick();









                                            validate();



                                        }

                                    }
            );


            btn24.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent event) {





                                            remove(label14);
                                            btn14.setVisible(false);
                                            btn24.setVisible(false);







                                            remove(firstFrame.game4);
                                            remove(firstFrame.game4.label);
                                            remove(firstFrame.game4.label1);
                                            remove(firstFrame.game4.button);




                                            validate();



                                        }

                                    }
            );

    }

}
