package com.github.jutiodjjex.messageforwarding;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStream;
import java.io.OutputStream;

public class Client {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        byte[] messageAsBytes = new byte[256];
        String serverAddress = getServerAddress();
        String message;
        try(Socket socket = new Socket(serverAddress, 9001);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream())
        {
            System.out.println("Введите сообщение: ");
            message = scan.nextLine();
            messageAsBytes = message.getBytes();
            out.write(messageAsBytes);

            in.read(messageAsBytes);
            System.out.println("Сервер прислал ответ: " + serverHandler.bytesToString(messageAsBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static String getServerAddress() {
        System.out.println("Введите адрес сервера: ");
        return scan.nextLine();

    }
}
