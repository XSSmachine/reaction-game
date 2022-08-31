import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuterClass {
    JLabel secondsLabel= new JLabel("...");

    Timer myTimer;

    public void setupTimer(int numSecondsToCountDown) {
        secondsLabel.setFont(new Font("Serif", Font.PLAIN, 60));
        secondsLabel.setText(Integer.toString(numSecondsToCountDown));
        myTimer = new Timer(1000, new CountdownListener(numSecondsToCountDown));
        myTimer.start();
    }

    // ...
    class CountdownListener implements ActionListener {
        private int secondsCount;

        public CountdownListener(int startingSeconds) { secondsCount = startingSeconds; }

        public void actionPerformed(ActionEvent evt) {
            secondsLabel.setText(Integer.toString(secondsCount));
            secondsCount--;


            if (secondsCount < 0) { // stop the countdown
                myTimer.stop();
            }
        }
    }
}
