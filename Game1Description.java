import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Game1Description extends JPanel {

    JButton btn1;
    JLabel label;

    public Game1Description(FirstFrame firstFrame) {
        setLayout(new GridLayout(2,1));

        btn1 = new JButton("Start");

        setBackground(Color.yellow);
        label = new JLabel("This game tests your reaction speed and you are required to click one time when the green button appears on the screen.");
        setForeground(Color.white);
        add(label);
        add(btn1);

        setVisible(true);




        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstFrame.swapCards(Game1.class.toString());


            }
            });

    }
}
