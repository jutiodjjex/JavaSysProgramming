package com.github.jutiodjjex.obfuscator;

import java.io.BufferedReader;

public class WriteThread extends Thread {

    private static String infoToWrite;

    public static void setInfoToWrite(String name) {
        infoToWrite = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        while (true) {
            System.out.println(infoToWrite.toString());
        }
    }
}
