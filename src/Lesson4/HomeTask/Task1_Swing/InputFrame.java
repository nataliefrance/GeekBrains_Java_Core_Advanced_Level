package Lesson4.HomeTask.Task1_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class InputFrame extends JFrame {
    InputFrame(MainWindow mainWindow) {
        setTitle("Input window");
        setBounds(500, 200, 300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        MyTextField fieldName = new MyTextField();
        MyTextField fieldSurname = new MyTextField();
        MyTextField fieldAge = new MyTextField();

        JLabel lName = new JLabel("Enter your name");
        JLabel lSurname = new JLabel("Enter your surname");
        JLabel lAge = new JLabel("Enter your age");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(e -> {
            String userName = fieldName.getText();
            String userSurname = fieldSurname.getText();
            String userAge = fieldAge.getText();
            mainWindow.initLabels(userName, userSurname, userAge);
            dispose();
        });

        add(panel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        panel.add(lName);
        panel.add(fieldName);
        panel.add(lSurname);
        panel.add(fieldSurname);
        panel.add(lAge);
        panel.add(fieldAge);

        setVisible(true);
    }

    class MyTextField extends JTextField implements FocusListener {
        MyTextField() {
            addFocusListener(this);
        }
        @Override
        public void focusGained(FocusEvent e) {
            setText("");
        }
        @Override
        public void focusLost(FocusEvent e) {
            setText(getText());
        }
    }
}
