import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game2Description extends JPanel {
    JButton btn2;
    JLabel label;

    public Game2Description(FirstFrame firstFrame){
        setLayout(new GridLayout(2,1));

        btn2 = new JButton("Start");

        setBackground(Color.yellow);
        label = new JLabel("This game tests your reaction speed and you are required to click one time when the green button appears on the screen.");
        setForeground(Color.white);
        add(label);
        add(btn2);

        setVisible(true);




        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstFrame.swapCards(Game2.class.toString());
                setVisible(false);



            }
        });

    }
}
