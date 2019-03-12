package Lesson4.HomeTask.Task1_Swing;

import javax.swing.*;
import java.awt.*;

/**
 * 1. Swing
 * создать окно
 * по нажатию конпки открывается второе окно и появляется 3 формы для ввода текста,
 * нажимаем кнопку сохранить окно закрывается и текст повялется в первом окне.
 */
public class MainWindow extends JFrame {

    private JLabel lName;
    private JLabel lSurname;
    private JLabel lAge;

    public MainWindow() {
        setTitle("Main window");
        setBounds(300, 300, 300, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("PRESS ME");
        button.addActionListener(e -> new InputFrame(this));

        lName = new JLabel("Name:");
        lSurname = new JLabel("Surname:");
        lAge = new JLabel("Age:");

        add(button, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

        panel.add(lName);
        panel.add(lSurname);
        panel.add(lAge);

        setVisible(true);
    }

    void initLabels(String userName, String userSurname, String userAge){
        lName.setText("Name: " + userName);
        lSurname.setText("Surname: " + userSurname);
        lAge.setText("Age: " + userAge);
    }
}


