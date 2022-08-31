import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game3Description extends JPanel {
    JButton btn3;
    JLabel label3;


    public Game3Description(FirstFrame firstFrame) {
        setLayout(new GridLayout(2,1));

        btn3 = new JButton("Start");

        setBackground(Color.yellow);
        label3 = new JLabel("This game tests your reaction speed and you are required to click one time when the green button appears on the screen.");
        setForeground(Color.white);
        add(label3);
        add(btn3);

        setVisible(true);




        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstFrame.swapCards(Game3.class.toString());
                setVisible(false);



            }
        });

    }
}
