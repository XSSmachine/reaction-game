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


public class ScoreScreen2 extends JPanel {
    JButton btn12;
    JButton btn22;
    JLabel label1;

    File file2  = new File("./players");
    File[] files2 = file2.listFiles();

    ScoreScreen2(FirstFrame firstFrame){

        Map<String, Integer> unsortedMap = new HashMap<String, Integer>();

        for(File f : files2){



            java.util.List<Integer> x_values1 = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(String.format("%s/" + "game2.csv", f)))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\n");
                    List<Integer> intValues = Arrays.asList(values).stream()
                            .map(Double::parseDouble) // parse x.xxE+02 to xxx.0
                            .map(Double::intValue) // xxx.0 to integer xxx
                            .collect(Collectors.toList()); // back to List
                    x_values1.addAll(intValues);
                    System.out.println(x_values1);
                    unsortedMap.put(f.getName().split(" ")[0], Collections.min(x_values1));
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

        add(btn12=new JButton(new SwapCardAction("PLAY AGAIN",
                KeyEvent.VK_R, Game2.class.toString(), firstFrame)));
        add(btn22 = new JButton(new SwapCardAction("MENU",
                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));
        setBackground(Color.CYAN);


        //firstFrame.game1.removeAll();

        btn12.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {




                                       remove(label1);
                                       btn12.setVisible(false);
                                       btn22.setVisible(false);


                                       remove(firstFrame.game2);
                                       remove(firstFrame.game2.button12);
                                       remove(firstFrame.game2.button22);
                                       remove(firstFrame.game2.button32);


                                       firstFrame.description2.btn2.doClick();









                                       validate();
                                       repaint();


                                   }

                               }
        );


        btn22.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {





                                       remove(label1);
                                       btn12.setVisible(false);
                                       btn22.setVisible(false);






                                       remove(firstFrame.game2);
                                       remove(firstFrame.game2.button12);
                                       remove(firstFrame.game2.button22);
                                       remove(firstFrame.game2.button32);




                                       validate();
                                       repaint();


                                   }

                               }
        );

    }


}
