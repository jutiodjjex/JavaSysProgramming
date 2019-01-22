package com.github.jutiodjjex.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Работа по протоколу TCP
 * Сервер получает байт (число)
 * и возвращает клиенту квадрат числа
 */
@SuppressWarnings("InfiniteLoopStatement")
public class SqServer {
    private static final Logger LOG = Logger.getLogger(SqServer.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serveClient(socket);
            }
        }
    }

    private static void serveClient(Socket socket) throws IOException {
        LOG.info("Serving client" + socket.getInetAddress());

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        while (true) {
            int request = inputStream.read();
            if (request == -1) {
                break;
            }
            LOG.info("Request:" + request);
            outputStream.write(request * request);
            outputStream.flush();
        }
    }
}
