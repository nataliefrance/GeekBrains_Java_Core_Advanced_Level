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
            server = new ServerSocket(8190);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
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
        broadcastClientlist();
    }

    void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientlist();
    }

    void broadcastMsg(ClientHandler from, String message) {
        for (ClientHandler o : clients) {
            if (!from.checkBlackList(o.getNick())) {
                o.sendMsg(message);
            }
        }
    }

    void broadcastClientlist(){
        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");

        for (ClientHandler o : clients) {
            sb.append(o.getNick() + " ");
        }

        String out = sb.toString();

        for (ClientHandler o : clients) {
            o.sendMsg(out);
        }
    }

    void sendPersonalMessage(ClientHandler from, String nickTo, String message) {
        for (ClientHandler o : clients) {
            if (nickTo.equals(o.getNick())) {
                if (o.checkBlackList(from.getNick())) {
                    from.sendMsg("Клиент " + nickTo + " добавил Вас в чёрный список");
                    return;
                }
                if (!from.checkBlackList(nickTo)) {
                    o.sendMsg("from " + from.getNick() + ": " + message);
                    from.sendMsg("to " + nickTo + ": " + message);
                    return;
                } else {
                    from.sendMsg("Клиент " + nickTo + " в чёрном списке");
                    return;
                }
            }
        }
        from.sendMsg("Клиент с ником " + nickTo + " не найден");
    }

    boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public Vector<ClientHandler> getClients() {
        return clients;
    }
}
