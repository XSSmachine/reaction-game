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

public class ScoreScreen3 extends JPanel {

    JButton btn13;
    JButton btn23;
    JLabel label13;

    File file3  = new File("./players");
    File[] files3 = file3.listFiles();


    ScoreScreen3(FirstFrame firstFrame) {

        Map<String, Integer> unsortedMap = new HashMap<String, Integer>();

        for(File f : files3){



            java.util.List<Integer> x_values1 = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(String.format("%s/" + "game3.csv", f)))) {
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

        add(btn13=new JButton(new SwapCardAction("PLAY AGAIN",
                KeyEvent.VK_R, Game3.class.toString(), firstFrame)));
        add(btn23 = new JButton(new SwapCardAction("MENU",
                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));



        setBackground(Color.CYAN);

        btn13.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {




                                        remove(label13);
                                        btn13.setVisible(false);
                                        btn23.setVisible(false);



                                        remove(firstFrame.game3);
                                        remove(firstFrame.game3.textField);
                                        remove(firstFrame.game3.label3);



                                        firstFrame.description3.btn3.doClick();









                                        validate();



                                    }

                                }
        );


        btn23.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent event) {





                                        remove(label13);
                                        btn13.setVisible(false);
                                        btn23.setVisible(false);







                                        remove(firstFrame.game3);
                                        remove(firstFrame.game3.textField);
                                        remove(firstFrame.game3.label3);




                                        validate();



                                    }

                                }
        );


    }
}
