import java.io.*;


public class RewriteIntToLuckyTxt{

    private DataInputStream dataInputStream;
    private BufferedWriter bufferedWriter;

    public RewriteIntToLuckyTxt(String fileInt, String fileTxt){

        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileInt));
            bufferedWriter = new BufferedWriter(new FileWriter(fileTxt));
        }catch (IOException error){
            error.printStackTrace();
        }

    }

    public void rewrite(){

        int buf = 0;
        String ticket = null;

        try {

            while (dataInputStream.available() > 0){

                buf = dataInputStream.readInt();
                ticket = translateToTicket(buf);

                System.out.println(ticket);

                if(isLuckyNumberStr(ticket)){
                    bufferedWriter.write(ticket);
                    bufferedWriter.newLine();
                }
            }

        }catch (IOException error){
            error.printStackTrace();
        }

    }


    private String translateToTicket(int number){

        String str = Integer.toString(number);
        char[] chars = new char[6];

        int i = chars.length - 1;

        for(int len = str.length() - 1; len >= 0; --len, --i){
            chars[i] = str.charAt(len);
        }
        for( ; i >= 0; --i){
            chars[i] = '0';
        }

        return new String(chars);

    }

    private boolean isLuckyNumberStr(String str){
        return str.charAt(0) + str.charAt(1) + str.charAt(2) == str.charAt(3) + str.charAt(4) + str.charAt(5);
    }

    private boolean isLuckyNumberInt(int n){
        int a = (n / 100000) + ((n / 10000) % 10) + ((n / 1000) % 10);
        int b = (n % 10) + ((n % 100) / 10) + ((n % 1000) / 100);

        return  (a == b);
    }

    public void close(){

        try{

            dataInputStream.close();
            bufferedWriter.close();

        }catch (IOException error){

            error.printStackTrace();

        }
    }

}