package Lesson6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

class MainServer {
    private Vector<ClientHandler> clients; //синхронизируемый Arraylist

    MainServer() {
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while (true) {
                //ожидаем подключения клиента
                socket = server.accept();
                System.out.println("Клиент подключился");
                subscribe(new ClientHandler(this, socket)); //добавляем новое подключение в список
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Сервер отключён");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void broadcast(String message) {
        for (ClientHandler cl : clients) {
            cl.sendMessage(message);
        }
    }

    public void subscribe(ClientHandler handler){
        clients.add(handler);
    }

    public void unsubscribe(ClientHandler handler){
        clients.remove(handler);
        System.out.println("Клиент отключился.");
    }

//    public Vector<ClientHandler> getClients() {
//        return clients;
//    }
}
