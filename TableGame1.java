import com.opencsv.CSVReader;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class TableGame1 extends JPanel {
    Object[] columnnames;
    transient CSVReader CSVFileReader;

    JTable MyJTable;


    TableGame1(FirstFrame firstFrame) {
        firstFrame.main.STATSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                try {
                    CSVFileReader = new CSVReader(new FileReader(String.format("C:/%s/" + "game1.csv", firstFrame.login.ime1)));
                    List myEntries = CSVFileReader.readAll();
                    columnnames = (String[]) myEntries.get(0);
                    DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size() - 1);
                    int rowcount = tableModel.getRowCount();
                    for (int x = 0; x < rowcount + 1; x++) {
                        int columnnumber = 0;
                        // if x = 0 this is the first row...skip it... data used for columnnames
                        if (x > 0) {
                            for (String thiscellvalue : (String[]) myEntries.get(x)) {
                                tableModel.setValueAt(thiscellvalue, x - 1, columnnumber);
                                columnnumber++;
                            }
                        }
                    }

                    MyJTable = new JTable(tableModel);

                    add(MyJTable);
                    setVisible(true);
                } catch (Exception eee) {
                    eee.printStackTrace();
                }
            }


        });
    }
}

