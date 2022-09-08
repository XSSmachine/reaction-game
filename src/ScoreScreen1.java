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

public class ScoreScreen1 extends JPanel {



    JButton btn1;
    JButton btn2;
    JLabel label;

    File file1  = new File("./players");
    File[] files1 = file1.listFiles();













    public ScoreScreen1(FirstFrame firstFrame) {

        Map<String, Integer> unsortedMap = new HashMap<String, Integer>();

        for(File f : files1){



                java.util.List<Integer> x_values1 = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(String.format("%s/" + "game1.csv", f)))) {
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



        add(btn1=new JButton(new SwapCardAction("PLAY AGAIN",
                KeyEvent.VK_R, Game1.class.toString(), firstFrame)));
        add(btn2 = new JButton(new SwapCardAction("MENU",
                KeyEvent.VK_R, MainScreen.class.toString(), firstFrame)));
        setBackground(Color.CYAN);


        //firstFrame.game1.removeAll();

        btn1.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent event) {




                                       remove(label);
                                       remove(firstFrame.game1.label1);
                                       remove(firstFrame.game1);
                                       remove(firstFrame.game1.button1);

                                       firstFrame.description1.btn1.doClick();









                                       validate();


                                   }

                               }
        );


            btn2.addActionListener(new ActionListener() {
                                       public void actionPerformed(ActionEvent event) {





                                           remove(label);
                                           remove(firstFrame.game1.label1);





                                           remove(firstFrame.game1);
                                           remove(firstFrame.game1.button1);



                                           validate();


                                       }

                                   }
            );

        }





}




