import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;



public class ScoreScreen2 extends JPanel {
    JButton btn12;
    JButton btn22;
    JLabel label1;

    ScoreScreen2(FirstFrame firstFrame){
        add(btn12=new JButton(new SwapCardAction("PLAY AGAIN",
                KeyEvent.VK_R, Game2.class.toString(), firstFrame)));
        add(btn22 = new JButton(new SwapCardAction("MENU",
                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));
        setBackground(Color.CYAN);


        //firstFrame.game1.removeAll();

        btn12.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {




                                       remove(label1);
                                       btn12.setVisible(false);
                                       btn22.setVisible(false);


                                       remove(firstFrame.game2);
                                       remove(firstFrame.game2.button12);
                                       remove(firstFrame.game2.button22);
                                       remove(firstFrame.game2.button32);


                                       firstFrame.description2.btn2.doClick();









                                       validate();
                                       repaint();


                                   }

                               }
        );


        btn22.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {





                                       remove(label1);
                                       btn12.setVisible(false);
                                       btn22.setVisible(false);






                                       remove(firstFrame.game2);
                                       remove(firstFrame.game2.button12);
                                       remove(firstFrame.game2.button22);
                                       remove(firstFrame.game2.button32);




                                       validate();
                                       repaint();


                                   }

                               }
        );

    }


}
