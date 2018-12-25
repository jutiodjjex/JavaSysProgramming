package SynchrinizedCopy;

import java.io.*;
import java.lang.String;

public class CopyingThread extends Thread {
    private String source;
    private String destination;
    ICopyResult(String name, String source, String destination) {
        setName(name);
        this.source = source;
        this.destination = destination;
    }

    /**
     * Копирование файлов.
     */
    @Override
    public void run() {

        try (InputStream is = new FileInputStream(source);
             FileOutputStream os = new FileOutputStream(destination))
        {

        }

        } catch (IOException e) {
            e.printStackTrace();
    }
}
