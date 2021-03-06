package Lesson6.server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {

    private MainServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private List<String> blackList;

    ClientHandler(MainServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.blackList = new ArrayList<>();
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = DataBaseService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    if (!server.isNickBusy(newNick)) {
                                        sendMsg("/authok");
                                        nick = newNick;
                                        blackList = DataBaseService.loadBlacklist(nick);
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        sendMsg("Учётная запись уже используется");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль");
                                }
                            }
                        }

                        while (true) {
                            String message = in.readUTF();
                            if (message.startsWith("/")) {
                                if (message.startsWith("/history ")) {
                                    StringBuilder stringBuilder = DataBaseService.getHistoryChat();
                                    out.writeUTF(stringBuilder.toString());
                                }
                                if (message.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }
                                if (message.startsWith("/w")) {
                                    String[] tokens = message.split(" ", 3);
                                    try {
                                        server.sendPersonalMessage(ClientHandler.this, tokens[1], tokens[2]);
                                    } catch (ArrayIndexOutOfBoundsException e){
                                        sendMsg("Вы ввели не всё сообщение");
                                    }
                                }
                                if (message.startsWith("/blacklist")){
                                    String[] tokens = message.split(" ");
                                    try {
                                        blackList.add(tokens[1]);
                                        sendMsg("Вы добавили пользователя " + tokens[1] + " в чёрный список");
                                    } catch (ArrayIndexOutOfBoundsException e){
                                        sendMsg("Вы ввели не всё сообщение");
                                    }
                                }
                                if(message.startsWith("/remove")){
                                    String[] tokens = message.split(" ");
                                    blackList.remove(tokens[1]);
                                    sendMsg("Вы удалили пользователя " + tokens[1] + " из чёрного списка");
                                }
                            } else {
                                DataBaseService.saveHistory(nick, message);
                                server.broadcastMsg(ClientHandler.this, nick + ": " + message);
                            }
                            System.out.println("Client: " + message);
                        }
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            DataBaseService.saveBlacklist(nick, blackList);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        try {
                            in.close();
                            out.close();
                            socket.close();
                        } catch (IOException  e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                        System.out.println("Клиент отключился");
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean checkBlackList(String nick){
        return blackList.contains(nick);
    }


    void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getNick() {
        return nick;
    }
}
