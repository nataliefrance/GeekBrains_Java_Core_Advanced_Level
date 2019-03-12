package Lesson4.NetworkChat;

import javax.swing.*;
import java.awt.*;

public class WindowChat extends JFrame {

    public WindowChat(){
        setTitle("Simple network chat");
        setBounds(800, 300, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        bottomPanel.setPreferredSize(new Dimension(1, 40));

        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        bottomPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new BorderLayout());

        JButton sendButton = new JButton("SEND");
        JTextField textField = new JTextField();

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        centerPanel.add(scrollPane);
        bottomPanel.add(sendButton);
        bottomPanel.add(textField);

        textField.setPreferredSize(new Dimension(300, 28));
        textArea.setEditable(false);

        sendButton.addActionListener(e -> {
            textArea.append(textField.getText() + "\n"); //Метод append() позволяет присоединить к уже имеющемуся в поле тексту новую часть без удаления прежнего содержимого
            textField.setText("");
            textField.grabFocus();
        });

        setVisible(true);
    }
}
