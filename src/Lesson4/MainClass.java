package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
    public static void main(String[] args) {

        new MyWindow();

    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Java Swing");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        bottomPanel.setPreferredSize(new Dimension(1,40));
        // bottomPanel.setBackground(Color.gray);

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JButton jbtn = new JButton("Send");

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);

        JTextField jtf = new JTextField();

        bottomPanel.add(jtf);
        bottomPanel.add(jbtn);

        jtf.setPreferredSize(new Dimension(300,28));
        jta.setEditable(false);


        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });
        setVisible(true);
    }

}







//        JButton jbt1 = new JButton("Ok");
//        add(jbt1, BorderLayout.SOUTH);
//
//        jbt1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("press button ok");
//                System.out.println(getClass().getName());
//            }
//        });


//        JButton jbt2 = new JButton("Cancel");
//        JButton jbt3 = new JButton("btn1");
//        JButton jbt4 = new JButton("btn1");
//
//        JPanel jPanel = new JPanel(new GridLayout(1,2));
//        jPanel.add(jbt1);
//        jPanel.add(jbt2);
//
//        jbt1.setPreferredSize(new Dimension(200,300));

//     add(jPanel, BorderLayout.SOUTH);

//        JButton[] jbs = new JButton[10];
//        setLayout(new FlowLayout());
//
//
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            add(jbs[i]);
//        }

//        setLayout(null);
//        JButton button1 = new JButton("Button 1");
//        button1.setBounds(55, 55, 85, 30);
//        add(button1);
