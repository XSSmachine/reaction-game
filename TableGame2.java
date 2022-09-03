import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TableGame2 extends JPanel {
    TableGame2(FirstFrame firstFrame){
        firstFrame.main.STATSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(String.format("C:/%s/" + "game1.csv", firstFrame.login.ime1)));
                    String line = "";
                    String DELIMITER = "|";
                    List<String> records = new ArrayList<>();
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(DELIMITER);
                        records.add(values[2]);
                    }
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Scores", (Vector<?>) records);
                    System.out.println(records);
                    JTable table = new JTable(model);
                    add(table);
                    setVisible(true);
                } catch (Exception eeee) {
                    eeee.printStackTrace();
                }
            }
        });

    }
}
