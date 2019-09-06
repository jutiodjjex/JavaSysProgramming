
import java.io.*;


public class RewriteIntAs6Int{

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public RewriteIntToInt6(String fileInt1, String fileInt2){

        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileInt1));
            dataOutputStream = new DataOutputStream(new FileOutputStream(fileInt2));
        }catch (IOException error){
            error.printStackTrace();
        }

    }

    public void rewrite(){

        int buf = 0;

        try {

            while (dataInputStream.available() > 0){
                buf = dataInputStream.readInt();

                if(buf >= 100000 && buf <= 999999){
                    dataOutputStream.writeInt(buf);
                }
            }

        }catch (IOException error){
            error.printStackTrace();
        }

    }

    public void close(){

        try{

            dataInputStream.close();
            dataOutputStream.close();

        }catch (IOException error){

            error.printStackTrace();

        }
    }

}