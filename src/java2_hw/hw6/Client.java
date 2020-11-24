package java2_hw.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 8888;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Подключение к серверу прошло успешно");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        //поток отправки сообщений и контроль завершения
        Thread outThread = new Thread(() -> {
            while (true){
                try {
                    String clientMsg = scanner.nextLine();
                    out.writeUTF(clientMsg);

                    if (clientMsg.equals("/end")) {
                        System.out.println("Вы ввели стоп-слово)");
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //поток приема сообщений
        Thread inThread = new Thread(() -> {
            while (true){
                try {
                    System.out.println("От сервера: " + in.readUTF());
                } catch (IOException e) {
                    break;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
