import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreScreen4 extends JPanel{
    JButton btn14;
    JButton btn24;
    JLabel label14;

    File file4  = new File("./players");
    File[] files4 = file4.listFiles();
    ScoreScreen4(FirstFrame firstFrame){


        Map<String, Integer> unsortedMap = new HashMap<String, Integer>();

        for(File f : files4){



            java.util.List<Integer> x_values1 = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(String.format("%s/" + "game4.csv", f)))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\n");
                    List<Integer> intValues = Arrays.asList(values).stream()
                            .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                            .map(Double::intValue) // xxx.0 to integer xxx
                            .collect(Collectors.toList()); // back to List
                    x_values1.addAll(intValues);
                    System.out.println(x_values1);
                    unsortedMap.put(f.getName().split(" ")[0], Collections.max(x_values1));
                }

            } catch (IOException ee) {
                ee.printStackTrace();
            }



        }

        Map<String, Integer> sortedMap = LeaderBoard.sortByValue(unsortedMap);

        JTextArea lider = new JTextArea();
        lider.setText(LeaderBoard.printMap(sortedMap));
        lider.setEditable(false);
        add(lider);





            add(btn14=new JButton(new SwapCardAction("PLAY AGAIN",
                    KeyEvent.VK_R, Game4.class.toString(), firstFrame)));
            add(btn24 = new JButton(new SwapCardAction("MENU",
                    KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));



            setBackground(Color.CYAN);

            btn14.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent event) {




                                            remove(label14);
                                            btn14.setVisible(false);
                                            btn24.setVisible(false);



                                            remove(firstFrame.game4);
                                            remove(firstFrame.game4.label);
                                            remove(firstFrame.game4.label1);
                                            remove(firstFrame.game4.button);



                                            firstFrame.description4.btn4.doClick();









                                            validate();



                                        }

                                    }
            );


            btn24.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent event) {





                                            remove(label14);
                                            btn14.setVisible(false);
                                            btn24.setVisible(false);







                                            remove(firstFrame.game4);
                                            remove(firstFrame.game4.label);
                                            remove(firstFrame.game4.label1);
                                            remove(firstFrame.game4.button);




                                            validate();



                                        }

                                    }
            );

    }

}
