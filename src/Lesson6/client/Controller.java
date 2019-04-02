package Lesson6.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextArea chatArea;

    @FXML
    TextField textField;

    @FXML
    Button btn;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    ListView<String> clientList;

    @FXML
    List<TextArea> textAreas;

    private boolean isAuthorized;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADRESS = "localhost";
    final int PORT = 8190;

    private void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        textAreas = new ArrayList<>();
        textAreas.add(chatArea);
        if (!isAuthorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientList.setVisible(false);
            clientList.setManaged(false);
        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientList.setVisible(true);
            clientList.setManaged(true);
        }
    }



    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void connect() {
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
                            if (message.startsWith("/authok")) {
                                setAuthorized(true);
                                break;
                            } else {
                                for (TextArea area : textAreas) {
                                    area.appendText(message + "\n");
                                }
                            }
                        }

                        while (true) {
                            String message = in.readUTF();
                            if (message.startsWith("/")) {
                                if (message.equals("/serverclosed")) {
                                    break;
                                }
                                if(message.startsWith("/clientlist")){
                                    String[] tokens = message.split(" ");
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            clientList.getItems().clear();
                                            for (int i = 1; i < tokens.length; i++) {
                                                clientList.getItems().add(tokens[i]);
                                            }
                                        }
                                    });
                                }
                            } else {
                                chatArea.appendText(message + "\n");
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setAuthorized(false);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectClient(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 1) {
            PersonalStage ps = new PersonalStage(clientList.getSelectionModel().getSelectedItem(), out, textAreas);
            ps.show();
        }
    }
}