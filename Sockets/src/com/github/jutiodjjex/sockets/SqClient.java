package com.github.jutiodjjex.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Работа по протоколу TCP
 * Клиент отправляет байт (число) серверу,
 * затем получает и выводит квадрат числа
 */
public class SqClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(4);
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            int response = inputStream.read();
            System.out.println(response);


        }
    }
}