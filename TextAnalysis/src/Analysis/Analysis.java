package Analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


 class Analysis {

    private static final int CHARS_BUFFER_SIZE = 256;

    private int symbols;
    private int spaces;
    private int lines;
    private int words;


    /**
     * Метод для:
     * Подсчет кол-ва всех символов, включая пробелы.
     * Подсчет кол-ва пробелов.
     * Подсчет кол-ва слов.
     * Подсчет кол-ва строк.
     *
     * @param filePath - путь к файлу, анализ которого нужно провести.
     */
    void getCount(String filePath) throws IOException {

        symbols = 0;
        spaces  = 0;
        lines   = 1;
        words   = 0;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        char[] charsBuffer = new char[CHARS_BUFFER_SIZE];

        int i = 1;
        int readChars;

        if((readChars = bufferedReader.read(charsBuffer)) > -1 && charsBuffer[0] >= 32 && charsBuffer[0] != ' '){
            words++;
        }

        do{

            if(charsBuffer[0] == ' '){
                spaces++;
            }

            if(charsBuffer[0] == '\n'){
                lines++;
            }

            if(charsBuffer[0] >= 32){
                symbols++;
            }

            while (i < readChars){

                if(charsBuffer[i] == ' '){
                    spaces++;
                }

                if(charsBuffer[i] == '\n'){
                    lines++;
                }

                if(charsBuffer[i] >= 32){
                    symbols++;
                }

                if((charsBuffer[i - 1] == ' ') && (charsBuffer[i] >= 32)){
                    words++;
                }
                i++;
            }
            i = 1;

        }while ((readChars = bufferedReader.read(charsBuffer)) > -1);

    }


    /**
     * Метод для:
     * вывода анализа текста.
     *
     * @return - возвращает анализ текста в строковом формате.
     */
    String getOutput() {

        return    "Symbols: "   + symbols +
                "\nSpaces: " + spaces  +
                "\nLines: "  + lines   +
                "\nWords: "  + words   + "\n";

    }

}