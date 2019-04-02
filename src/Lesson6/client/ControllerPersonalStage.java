package Lesson6.client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ControllerPersonalStage {
    @FXML
    TextArea textArea;

    @FXML
    Button btn;

    public void btnClick(){
        if(!((PersonalStage)btn.getScene().getWindow()).parentList.contains(textArea)) {
            ((PersonalStage)btn.getScene().getWindow()).parentList.add(textArea);
            System.out.println("1");
        }
        DataOutputStream out = ((PersonalStage)btn.getScene().getWindow()).out;
        String nickTo = ((PersonalStage)btn.getScene().getWindow()).nickTo;
        try {
            out.writeUTF("/w " + nickTo + " 111");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
