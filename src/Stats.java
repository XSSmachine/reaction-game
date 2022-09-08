import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



public class Stats extends JPanel {



    JButton btn1,btn2,btn3,btn4;
    JScrollPane tableContainer;
    JList list;
    JTabbedPane tabbedPane;

    JComponent panel1,panel2,panel3,panel4;

    JLabel label1,label2,label3,label4;

    java.util.List<Integer> x_values1,x_values2,x_values3,x_values4;

    Stats(FirstFrame firstFrame)  {

        super(new GridLayout(1, 1, 1, 1));




        revalidate();





        firstFrame.main.STATSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent evt) {
                tabbedPane = new JTabbedPane();
                panel1 = makeTextPanel(null);
                panel2 = makeTextPanel(null);
                panel3 = makeTextPanel(null);
                panel4 = makeTextPanel(null);


                int num = 0;
                int sum = 0;
                int avg = 0;
                int min = 0;
                int max = 0;
                int i = 0;


                x_values1 = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(String.format("./players/%s/"+"game1.csv",firstFrame.login.ime1)))) {
                    String line;

                    while ((line = br.readLine()) != null) {
                        String[] values = line.split("\n");
                        List<Integer> intValues = Arrays.asList(values).stream()
                                .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                                .map(Double::intValue) // xxx.0 to integer xxx
                                .collect(Collectors.toList()); // back to List
                        x_values1.addAll(intValues);
                    }

                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                for (i = 0; i < x_values1.size(); i++) {


                    num = x_values1.get(i);


                    sum += num;
                }

                max = Collections.max(x_values1);
                min = Collections.min(x_values1);
                avg = sum / i;


                System.out.println(x_values1);
                list = new JList<>(x_values1.toArray());
                tableContainer = new JScrollPane(list);

                panel1.add(label1=new JLabel((String.format("Hello, %s!",(firstFrame.login.ime1).split(" ")[0]))),BorderLayout.LINE_START);
                panel1.add(label2=new JLabel("Your average score for Game1 is "+avg+" ms"));
                panel1.add(label3=new JLabel("Your best score for Game1 is "+min+" ms"));
                panel1.add(label4=new JLabel("Your worst score for Game1 is "+max+" ms"));
                panel1.add(tableContainer);
                panel1.add(btn1=new JButton(new SwapCardAction("MENU",
                        KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));




                tabbedPane.addTab("Game1", null, panel1,
                        "Game1 Statistics");
                tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

                //-----------------------------------------------------------------------------------------------------------------------



                int num2 = 0;
                int sum2 = 0;
                int avg2 = 0;
                int min2 = 0;
                int max2 = 0;
                int i2 = 0;


                x_values2 = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(String.format("./players/%s/"+"game2.csv",firstFrame.login.ime1)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split("\n");
                        List<Integer> intValues = Arrays.asList(values).stream()
                                .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                                .map(Double::intValue) // xxx.0 to integer xxx
                                .collect(Collectors.toList()); // back to List
                        x_values2.addAll(intValues);
                    }

                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                for (i2 = 0; i2 < x_values2.size(); i2++) {


                    num2 = x_values2.get(i2);


                    sum2 += num2;
                }

                max2 = Collections.max(x_values2);
                min2 = Collections.min(x_values2);
                avg2 = sum2 / i2;


                System.out.println(x_values2);
                list = new JList<>(x_values2.toArray());
                tableContainer = new JScrollPane(list);

                panel2.add(new JLabel((String.format("Hello, %s!",(firstFrame.login.ime1).split(" ")[0]))),BorderLayout.LINE_START);
                panel2.add(new JLabel("Your average score for Game1 is "+avg2+" ms"));
                panel2.add(new JLabel("Your best score for Game1 is "+min2+" ms"));
                panel2.add(new JLabel("Your worst score for Game1 is "+max2+" ms"));
                panel2.add(tableContainer);
                panel2.add(btn2=new JButton(new SwapCardAction("MENU",
                        KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));

                tabbedPane.addTab("Game2", null, panel2,
                        "Game2 Statistics");
                tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

                //-----------------------------------------------------------------------------------------------------------------------




                int num3 = 0;
                int sum3 = 0;
                int avg3 = 0;
                int min3 = 0;
                int max3 = 0;
                int i3 = 0;


                x_values3 = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(String.format("./players/%s/"+"game3.csv",firstFrame.login.ime1)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split("\n");
                        List<Integer> intValues = Arrays.asList(values).stream()
                                .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                                .map(Double::intValue) // xxx.0 to integer xxx
                                .collect(Collectors.toList()); // back to List
                        x_values3.addAll(intValues);
                    }

                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                for (i3 = 0; i3 < x_values3.size(); i3++) {


                    num3 = x_values3.get(i3);


                    sum3 += num3;
                }

                max3 = Collections.max(x_values3);
                min3 = Collections.min(x_values3);
                avg3 = sum3 / i3;


                System.out.println(x_values3);
                list = new JList<>(x_values3.toArray());
                tableContainer = new JScrollPane(list);

                panel3.add(new JLabel((String.format("Hello, %s!",(firstFrame.login.ime1).split(" ")[0]))),BorderLayout.LINE_START);
                panel3.add(new JLabel("Your average score for Game1 is "+avg3+" wpm"));
                panel3.add(new JLabel("Your best score for Game1 is "+min3+" wpm"));
                panel3.add(new JLabel("Your worst score for Game1 is "+max3+" wpm"));
                panel3.add(tableContainer);
                panel3.add(btn3=new JButton(new SwapCardAction("MENU",
                        KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));

                tabbedPane.addTab("Game3", null, panel3,
                        "Game3 Statistics");
                tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//-----------------------------------------------------------------------------------------------------------------------


                int num4 = 0;
                int sum4 = 0;
                int avg4 = 0;
                int min4 = 0;
                int max4 = 0;
                int i4 = 0;


                x_values4 = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(String.format("./players/%s/"+"game4.csv",firstFrame.login.ime1)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split("\n");
                        List<Integer> intValues = Arrays.asList(values).stream()
                                .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                                .map(Double::intValue) // xxx.0 to integer xxx
                                .collect(Collectors.toList()); // back to List
                        x_values4.addAll(intValues);
                    }

                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                for (i4 = 0; i4 < x_values4.size(); i4++) {


                    num4 = x_values4.get(i4);


                    sum4 += num4;
                }

                max4 = Collections.max(x_values4);
                min4 = Collections.min(x_values4);
                avg4 = sum4 / i4;


                System.out.println(x_values4);
                list = new JList<>(x_values4.toArray());
                tableContainer = new JScrollPane(list);

                panel4.add(new JLabel((String.format("Hello, %s!",(firstFrame.login.ime1).split(" ")[0]))),BorderLayout.LINE_START);
                panel4.add(new JLabel("Your average score for Game1 is "+avg4+" #"));
                panel4.add(new JLabel("Your best score for Game1 is "+min4+" #"));
                panel4.add(new JLabel("Your worst score for Game1 is "+max4+" #"));
                panel4.add(tableContainer);
                panel4.add(btn4=new JButton(new SwapCardAction("MENU",
                        KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));

                panel4.setPreferredSize(new Dimension(410, 50));
                tabbedPane.addTab("Game4", null, panel4,
                        "Does nothing at all");
                tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

                //Add the tabbed pane to this panel.
                add(tabbedPane);

                //The following line enables to use scrolling tabs.
                tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);





                btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        remove(firstFrame.stats.panel1);
                        remove(firstFrame.stats.panel2);
                        remove(firstFrame.stats.panel3);
                        remove(firstFrame.stats.panel4);
                        remove(firstFrame.stats.tabbedPane);
                        removeAll();

                        panel1.setVisible(false);
                        panel2.setVisible(false);
                        panel3.setVisible(false);
                        panel4.setVisible(false);

                    }
                });
                btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        remove(firstFrame.stats.panel1);
                        remove(firstFrame.stats.panel2);
                        remove(firstFrame.stats.panel3);
                        remove(firstFrame.stats.panel4);
                        remove(firstFrame.stats.tabbedPane);
                        removeAll();

                        panel1.setVisible(false);
                        panel2.setVisible(false);
                        panel3.setVisible(false);
                        panel4.setVisible(false);

                    }
                });
                btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        remove(firstFrame.stats.panel1);
                        remove(firstFrame.stats.panel2);
                        remove(firstFrame.stats.panel3);
                        remove(firstFrame.stats.panel4);
                        remove(firstFrame.stats.tabbedPane);
                        removeAll();

                        panel1.setVisible(false);
                        panel2.setVisible(false);
                        panel3.setVisible(false);
                        panel4.setVisible(false);

                    }
                });
                btn4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        remove(firstFrame.stats.panel1);
                        remove(firstFrame.stats.panel2);
                        remove(firstFrame.stats.panel3);
                        remove(firstFrame.stats.panel4);
                        remove(firstFrame.stats.tabbedPane);
                        removeAll();

                        panel1.setVisible(false);
                        panel2.setVisible(false);
                        panel3.setVisible(false);
                        panel4.setVisible(false);

                    }
                });
            }

        });


    }


    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        //JLabel filler = new JLabel(text);
        //filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(3, 2));
        //panel.add(filler);
        revalidate();
        repaint();
        return panel;

    }
}
