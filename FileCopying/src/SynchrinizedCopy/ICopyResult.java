package SynchrinizedCopy;

import java.io.*;
import java.lang.String;

public class ICopyResult extends Thread {
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

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поток закончил копирование. \n");
    }
}
