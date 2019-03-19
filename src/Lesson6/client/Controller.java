package Lesson6.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.util.Date;

public class Controller {
    @FXML
    private
    TextArea textArea;

    @FXML
    private
    TextField textField;

    @FXML
    Button btn;

    public void sendMsg() {
        DateFormat df = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        Date currentDate = new Date();
        textArea.appendText("[" + df.format(currentDate) + "] " + "\n");

        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
}
