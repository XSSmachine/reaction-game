import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game4Description extends JPanel {

    JButton btn4;
    JLabel label4;


    public Game4Description(FirstFrame firstFrame){
        setLayout(new GridLayout(2,1));

        btn4 = new JButton("Start");

        setBackground(Color.yellow);
        label4 = new JLabel("This game tests your reaction speed and you are required to click one time when the green button appears on the screen.");
        setForeground(Color.white);
        add(label4);
        add(btn4);

        setVisible(true);




        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstFrame.swapCards(Game4.class.toString());
                setVisible(false);



            }
        });

    }
}
