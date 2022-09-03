import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stats extends JPanel {

    JButton btn1;

    Stats(FirstFrame firstFrame)  {


        super(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane();
        

        JComponent panel1 = makeTextPanel("Panel #1");
       panel1.add(btn1=new JButton(new SwapCardAction("Game1 ALL SCORES",
               KeyEvent.VK_R, TableGame2.class.toString(), firstFrame)));

            //reader = new CSVReader(new FileReader("game1.csv"));
            //List myEntries = reader.readAll();
            //Iterator myIterator = myEntries.iterator();
            //JTable table = new JTable(myIterator.next());




        tabbedPane.addTab("Game1", null, panel1,
                "Game1 Statistics");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Game2", null, panel2,
                "Game2 Statistics");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Game3", null, panel3,
                "Game3 Statistics");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Game4", null, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);


    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
