import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


/**
 * Login class is the top card in the deck and it has a function of creating a folder of users username and password and making 4 .csv files,
 * where i planned to save statistics(didnt add that fun
 */
public class Login extends JPanel {

    JTextField t1, t2;
    JButton b1,b2;
    JLabel l1;

    String ime1;

    GroupLayout layout = new GroupLayout(this);
    public Login(FirstFrame firstFrame) {


        setLayout(layout);

        l1 = new JLabel("Login page");
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(130,10,300,35);

        add(l1);


        t1 = new JTextField(60);
        t2 = new JPasswordField(60);
        b1 = new JButton("Login");
        b2 = new JButton("Register");


        t1.setBounds(150,60,120,30);
        t2.setBounds(150,100,120,30);
        b1.setBounds(220,140,100,30);
        b2.setBounds(100,140,100,30);

        add(t1);
        add(t2);
        add(b1);
        add(b2);

        File file  = new File("C:/");
        File[] files = file.listFiles();




        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String ime = t1.getText().toString()+" "+t2.getText().toString();

                if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please enter both username and password correctly to register","Register error",JOptionPane.ERROR_MESSAGE);
                    t1.setText(null);
                    t2.setText(null);
                    return;



                }
                for(File f : files){
                    if(Objects.equals(f.getName(), ime)){
                        JOptionPane.showMessageDialog(null,"That user is already registered","Register error",JOptionPane.ERROR_MESSAGE);
                        t1.setText(null);
                        t2.setText(null);
                        return;

                    }

                }
                try {
                    File file = new File(ime);
                    new File("C:/"+ime).mkdirs();

                    JOptionPane.showMessageDialog(null, "Registration is complete, saving user to database and exiting program... ", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                    System.exit(0);
                    System.out.println("File: " + file);
                } catch(Exception e) {

                }
                //new File("C:/Users/Korisnik/IdeaProjects/Zavrsni_Projekt/"+ime).mkdirs();
                t1.setText(null);
                t2.setText(null);

            }


        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 ime1 = t1.getText().toString()+" " + t2.getText().toString();
                boolean flag = false;

                if(t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password correctly to login", "Login error", JOptionPane.ERROR_MESSAGE);
                    t1.setText(null);
                    t2.setText(null);
                    return ;
                }
                for (File f : files) {
                    System.out.println(f.getName());
                    if (Objects.equals(f.getName(), ime1)) {
                        flag = true;




                    }

                }if(flag) {


                    firstFrame.swapCards(MainScreen.class.toString());
                   
                    






                    JOptionPane.showMessageDialog(null, "Succesful login", "Win", JOptionPane.INFORMATION_MESSAGE);
                    t1.setText(null);
                    t2.setText(null);


                }else{

                    JOptionPane.showMessageDialog(null, "Unsuccessful login", "Win", JOptionPane.INFORMATION_MESSAGE);
                    t1.setText(null);
                    t2.setText(null);
                    return;


                    //else goes here
                }


            }


        });

    }
        //setBackground(new Color(150, 200, 255));
        //JPanel btnPanel = new JPanel();
        //btnPanel.add(gotToRegisterBtn);
        //btnPanel.setOpaque(false);

        //setLayout(new BorderLayout());
        //JLabel label = new JLabel("Login", SwingConstants.CENTER);
        //add(label, BorderLayout.CENTER);
        //add(btnPanel, BorderLayout.SOUTH);
    }


