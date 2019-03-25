package Lesson6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

class MainServer {
    private Vector<ClientHandler> clients;

    MainServer() throws SQLException {
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    void subscribe(ClientHandler client) {
        clients.add(client);
    }

    void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    void broadcastMsg(String message) {
        for (ClientHandler o : clients) {
            o.sendMsg(message);
        }
    }

    void sendPersonalMessage(ClientHandler from, String nickTo, String message){
        for (ClientHandler o : clients) {
            if (nickTo.equals(o.getNick())){
                o.sendMsg("from " + from.getNick() + ": " + message);
                from.sendMsg("to " + o.getNick() + ": " + message);
                return;
            }
        }
        from.sendMsg("Клиент с ником " + nickTo + " не найден");
    }

    boolean isNickBusy(String nick){
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)){
                return true;
            }
        }
        return false;
    }
}
