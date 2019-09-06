package com.github.jutiodjjex.messageforwarding;

import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class serverHandler extends Thread {

    private Socket socket;

    public serverHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        String message = null;
        byte[] messageAsBytes = new byte[256];
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            System.out.println("Новое соединение: " + socket.getInetAddress().toString());
            while (message == null) {
                in.read(messageAsBytes);
                message = bytesToString(messageAsBytes);
            }

            System.out.println("Клиент прислал сообщение : " + message);

            out.write(stringToBytes(message));

        } catch (
                IOException e) {
            System.out.println(e);
        }
        System.exit(-1);
    }

    public static String bytesToString(byte[] byteArray){
        String message = new String(byteArray);
        return message;
    }

    public static byte[] stringToBytes(String message){
        byte[] messageAsBytes = message.getBytes();
        return messageAsBytes;
    }
}
