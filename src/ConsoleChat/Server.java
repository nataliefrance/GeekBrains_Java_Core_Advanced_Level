package ConsoleChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader reader;
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public Server() {
        try {
            server = new ServerSocket(8190);
            System.out.println("Сервер запущен!");
            clientSocket = server.accept(); //ожидаем подключения клиента
            //поток, чтобы принимать сообщения
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // поток для отправки сообщений
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            //поток для получения сообщений от клиента
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String msgFromClient = in.readLine(); // ждём сообщение от клиента
                            System.out.println("Клиент говорит: " + msgFromClient);
                            if(msgFromClient.equalsIgnoreCase("/end")){
                                out.write("/serverClosed" + "\n"); // отправляем сообщение клиенту
                                out.flush();
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally { // в любом случае сокет будет закрыт
                        try {
                            System.out.println("Клиент отключился");
                            clientSocket.close();
                            in.close();
                            out.close();
                            System.out.println("Сервер закрыт!");
                            server.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            //Поток для отправки сообщений клиенту
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String message = reader.readLine(); // пишем сообщение в консоль
                            out.write(message + "\n"); // отправляем сообщение клиенту
                            out.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[]args){
        new Server();
    }
}
