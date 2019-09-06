/**
 *
 * Класс выполняющий запись найденных идентификаторов в файле исходного кода
 *
 *
 * @author Pronichkin Vyacheslav
 *
 */

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Main{


    private static final String SRC_FILE_PATH = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\Reg.java";
    private static final String ID_FILE_PATH  = "C:\\Users\\Rescue\\Documents\\GitHub\\Study\\Reg\\id.txt";
    private static final String REG_EXP = "\\b[a-zA-Z_]\\w*";


    public static void main(String[] args) {


        try{

            BufferedReader srcFile = new BufferedReader(new FileReader(SRC_FILE_PATH));
            BufferedWriter idFile  = new BufferedWriter(new FileWriter(ID_FILE_PATH));


            String lineBuf = null;
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = null;

            while ((lineBuf = srcFile.readLine()) != null){

                String[] ids = lineBuf.split("\\W");

                for(int i = 0; i < ids.length; ++i){

                    matcher = pattern.matcher(ids[i]);

                    if(matcher.matches()){

                        System.out.println(ids[i]);

                        idFile.write(ids[i]);
                        idFile.newLine();

                    }

                }

            }

            srcFile.close();
            idFile.close();

        }catch(IOException ioError){

            ioError.printStackTrace();

        }

    }

}