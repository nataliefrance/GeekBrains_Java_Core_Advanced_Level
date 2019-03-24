package Lesson6.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

//подписываем клиента на интерфейс Initializable для того,
// чтобы при запуске он пытался подключиться к нашему серверу
public class Controller implements Initializable {
    @FXML
    private
    TextArea textArea;

    @FXML
    private
    TextField textField;

    @FXML
    Button btn;

    Socket socket;
    DataInputStream in; //входящий поток
    DataOutputStream out; //исходящий поток

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = in.readUTF();
                            textArea.appendText(message + "\n");
                            if (message.equalsIgnoreCase("/serverClosed")){
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                            System.out.println("Клиент отключился. Сокет закрыт.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        /*DateFormat df = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        Date currentDate = new Date();
        textArea.appendText("[" + df.format(currentDate) + "] " + "\n");*/

        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
