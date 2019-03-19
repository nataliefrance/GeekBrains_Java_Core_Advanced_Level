package Lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MainServer {
    private Vector<ClientHandler> clients; //синхронизируемый Arraylist
    public MainServer() {
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
                clients.add(new ClientHandler(this, socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        }

        public void broadcast(String message){
            for (ClientHandler cl: clients) {
                cl.sendMessage(message);
            }
        }
    }
