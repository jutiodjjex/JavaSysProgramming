package com.github.jutiodjjex.obfuscator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class SearchThread extends Thread {
    private String path;

    Pattern dataTypesRegex;
    Pattern operationRegex;
    Pattern multistringCommentRegex;
    Pattern onelineCommentRegex;
    Pattern endOfAStringRegex;

    SearchThread(String path){
        this.path = path;
    }


    private static final String REGEX = "C:\\Users\\PryaN\\IdeaProjects\\Obfuscator\\src\\com\\github\\jutiodjjex\\obfuscator\\regextypes\\regextypes.txt";

    @Override
    public void run(){
        try
                (FileReader regexReader = new FileReader(REGEX);
        BufferedReader inStream = new BufferedReader(regexReader)) {
            ArrayList regexTypes = new ArrayList();
            for (int i = 0; i < 5; i++) {
                regexTypes.add(inStream.readLine());
                System.out.println(regexTypes.get(i));
            }
            dataTypesRegex = Pattern.compile(regexTypes.get(0).toString());
            operationRegex = Pattern.compile(regexTypes.get(1).toString());
            multistringCommentRegex = Pattern.compile(regexTypes.get(2).toString());
            onelineCommentRegex = Pattern.compile(regexTypes.get(3).toString());
            endOfAStringRegex = Pattern.compile(regexTypes.get(4).toString());
        }
            catch(IOException e){
                e.printStackTrace();
            }

        try
                (FileReader codeReader = new FileReader(path);
                 BufferedReader inStream = new BufferedReader(codeReader))
        {

            ArrayList codeByLines = new ArrayList();
            while((inStream.readLine()) != null) {
                codeByLines.add(inStream.readLine());
            }

            for(int i = 0; i < codeByLines.size(); i++){
                WriteThread.setInfoToWrite(codeByLines.get(i).toString());
            }

        } catch(IOException e){
            e.printStackTrace();
        }

    }

}
