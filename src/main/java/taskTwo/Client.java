package taskTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8083;
        Scanner sc = new Scanner(System.in);
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            String income = in.readLine();
            System.out.println(income);
            String answer = sc.nextLine();
            out.println(answer);
            System.out.println(in.readLine());
            socket.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
