package taskTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCities {
    public static void main(String[] args) {
        String city = null;
        try (ServerSocket serverSocket = new ServerSocket(8083);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    if (city == null) {
                        out.println("???");
                        city = in.readLine();
                        out.println("OK");
                    } else {
                        out.println(city);
                        String answer = in.readLine();
                        if (city.endsWith(String.valueOf(answer.charAt(0)))) {
                            city = answer;
                            out.println("OK");
                        } else {
                            out.println("NOT OK");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
