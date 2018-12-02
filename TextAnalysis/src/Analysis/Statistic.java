package Analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Statistic {

    private static final int CHARS_BUFFER_SIZE = 256;

    private int symbolCount;
    private int spaceCount;
    private int lineCount;
    private int wordCount;


    Statistic(String filePath) throws IOException {

        counter(filePath);

    }

    Statistic(){}

    void counter(String filePath) throws IOException {

        symbolCount = 0;
        spaceCount  = 0;
        lineCount   = 1;
        wordCount   = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        char[] charsBuffer = new char[CHARS_BUFFER_SIZE];

        int i = 1;
        int readChars;

        if((readChars = bufferedReader.read(charsBuffer)) > -1 && charsBuffer[0] >= 32 && charsBuffer[0] != ' '){

            wordCount++;

        }

        do{

            if(charsBuffer[0] == ' '){

                spaceCount++;

            }

            if(charsBuffer[0] == '\n'){

                lineCount++;

            }

            if(charsBuffer[0] >= 32){

                symbolCount++;

            }

            while (i < readChars){

                if(charsBuffer[i] == ' '){

                    spaceCount++;

                }

                if(charsBuffer[i] == '\n'){

                    lineCount++;

                }

                if(charsBuffer[i] >= 32){

                    symbolCount++;

                }

                if((charsBuffer[i - 1] == ' ') && (charsBuffer[i] >= 32)){

                    wordCount++;

                }

                i++;

            }

            i = 1;

        }while ((readChars = bufferedReader.read(charsBuffer)) > -1);

    }

    @Override
    public String toString() {

        return    "Symbol count: "   + Integer.toString(symbolCount) +
                "\nSpace count: " + Integer.toString(spaceCount)  +
                "\nLine count: "  + Integer.toString(lineCount)   +
                "\nWord count: "  + Integer.toString(wordCount)   + "\n";

    }

}