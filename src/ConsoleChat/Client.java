package ConsoleChat;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public Client() {
        try {
            clientSocket = new Socket("localhost", 8190); // запрашиваем у сервера доступ на соединение
            System.out.println("Клиент подключился!");
            reader = new BufferedReader(new InputStreamReader(System.in));
            // читать соообщения с сервера
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // писать серверу
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            //поток для отправки сообщений серверу
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Напишите сообщение серверу:");
                        while (true) {
                            String message = reader.readLine(); // пишем сообщение в консоль
                            out.write(message + "\n"); // отправляем сообщение на сервер
                            out.flush();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            reader.close();

            //поток для получения сообщений от сервера
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            String serverMsg = in.readLine(); // ждём сообщение от сервера
                            System.out.println("Сервер говорит: " + serverMsg);
                            if (serverMsg.equalsIgnoreCase("/serverClosed")) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            System.out.println("Клиент отключён");
                            clientSocket.close();
                            in.close();
                            out.close();
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

    public static void main(String[] args) {
        new Client();
    }
}
