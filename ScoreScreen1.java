import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ScoreScreen1 extends JPanel {
    JButton btn1;
    JButton btn2;
    JLabel label;












    public ScoreScreen1(FirstFrame firstFrame) {



        add(btn1=new JButton(new SwapCardAction("PLAY AGAIN",
                KeyEvent.VK_R, Game1.class.toString(), firstFrame)));
        add(btn2 = new JButton(new SwapCardAction("MENU",
                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));
        setBackground(Color.CYAN);


        //firstFrame.game1.removeAll();

        btn1.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {




                                       remove(label);
                                       remove(firstFrame.game1.label1);
                                       remove(firstFrame.game1);
                                       remove(firstFrame.game1.button1);

                                       firstFrame.description1.btn1.doClick();









                                       validate();


                                   }

                               }
        );


            btn2.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent event) {





                                           remove(label);
                                           remove(firstFrame.game1.label1);





                                           remove(firstFrame.game1);
                                           remove(firstFrame.game1.button1);



                                           validate();


                                       }

                                   }
            );

        }





}




