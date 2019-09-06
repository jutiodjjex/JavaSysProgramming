import java.io.*;


public class RewriteTxtToInt{

    private BufferedReader bufferedReader;
    private DataOutputStream dataOutputStream;

    public RewriteTxtToInt(String fileTxt, String fileInt){

        try {

            bufferedReader = new BufferedReader(new FileReader(fileTxt));
            dataOutputStream = new DataOutputStream(new FileOutputStream(fileInt));

        }catch (IOException error){

            error.printStackTrace();

        }

    }

    public void rewrite(){

        String buf = null;

        try {

            while ((buf = bufferedReader.readLine()) != null){
                dataOutputStream.writeInt(Integer.parseInt(buf));
            }

        }catch (IOException error){
            error.printStackTrace();
        }

    }

    public void close(){

        try{

            bufferedReader.close();
            dataOutputStream.close();

        }catch (IOException error){

            error.printStackTrace();

        }
    }

}