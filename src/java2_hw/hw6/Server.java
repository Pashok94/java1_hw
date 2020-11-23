package java2_hw.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8888;
    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    private boolean isClientActive;

    public Server() {
        try {
            this.server = new ServerSocket(PORT);
            System.out.println("Сервер запущен и ожидает подключение");
            this.socket = server.accept();
            System.out.println("Клиент подключился");
            isClientActive = true;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            scanner = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        //поток приема сообщений, контроль завершения
        Thread inThread = new Thread(() -> {
            while (true){
                try {
                    String clientsMsg = in.readUTF();
                    if (clientsMsg.equals("/end")) {
                        System.out.println("Клиент ввел стоп-слово)");
                        isClientActive = false;
                        break;
                    }
                    System.out.println("Клиент: " + clientsMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //поток отслеживания сканнера и отправки сообщений
        Thread outThread = new Thread(() -> {
            while (isClientActive){
                try {
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        inThread.start();
        outThread.start();
        try {
            inThread.join();
            outThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
