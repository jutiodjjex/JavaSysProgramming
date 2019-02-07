package com.github.jutiodjjex.obfuscator;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Math.toIntExact;

public class Main {

    static Pattern dataTypesRegex;
    static Pattern operationRegex;
    static Pattern multistringCommentRegex;
    static Pattern onelineCommentRegex;
    static Pattern endOfAStringRegex;

    static String code;


    public static void main(String[] args) {
        String path = "C:\\Users\\PryaN\\IdeaProjects\\Obfuscator\\src\\com\\github\\jutiodjjex\\obfuscator\\iofiles\\code_enter.txt";
        String path2 = "C:\\Users\\PryaN\\IdeaProjects\\Obfuscator\\src\\com\\github\\jutiodjjex\\obfuscator\\iofiles\\code_outer.txt";
        String regex = "C:\\Users\\PryaN\\IdeaProjects\\Obfuscator\\src\\com\\github\\jutiodjjex\\obfuscator\\regextypes\\regextypes.txt";
        ArrayList codeByLines = new ArrayList();


        regexInitialization(regex);
        codeByLines = codeLinesInitialization(path);
        dataTypesObfuscation(path2, codeByLines);
        operationsObfuscation(path2, codeByLines);
        multilineCommentObfuscation(path2);
        onelineCommentObfuscation(path2, codeByLines);
        multilineCommentObfuscation(path2);
        endOfAStringObfuscation(path2);
    }

    public static void regexInitialization(String regex) {
        try (
                FileReader regexReader = new FileReader(regex);
                BufferedReader inStream = new BufferedReader(regexReader)) {
            ArrayList regexTypes = new ArrayList();
            for (int i = 0; i < 5; i++) {
                regexTypes.add(inStream.readLine());
                System.out.println("Regex " + i + " : " + regexTypes.get(i));
            }
            dataTypesRegex = Pattern.compile("((public|private)?)+((\\s*)?)+((static)?)+((\\s*)?)+((final)?)+((\\s*)?)+(class|int|String|long|boolean|byte|char|short|float|double|void)+(\\s)+(\\w*)+((\\s)?)+(;|=|\\{)");
            operationRegex = Pattern.compile(regexTypes.get(1).toString());
            multistringCommentRegex = Pattern.compile(regexTypes.get(2).toString());
            onelineCommentRegex = Pattern.compile(regexTypes.get(3).toString());
            endOfAStringRegex = Pattern.compile(regexTypes.get(4).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList codeLinesInitialization(String path) {
        ArrayList codeByLines = new ArrayList();
        try
                (FileReader codeReader = new FileReader(path);
                 BufferedReader inStream = new BufferedReader(codeReader)) {

            int linesCount = getAmountOfLines(path);

            for (int i = 0; i < linesCount; i++) {
                codeByLines.add(inStream.readLine());
                code = code + "\n" + codeByLines.get(i);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return codeByLines;
    }

    public static int getAmountOfLines(String path) {
        int linesCount = 0;
        try
                (FileReader codeReader = new FileReader(path);
                 BufferedReader inStream = new BufferedReader(codeReader)) {
            linesCount = toIntExact(inStream.lines().count());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesCount;
    }


    private static void dataTypesObfuscation(String path, ArrayList codeByLines) {
        try (
                FileWriter obfuscatedCodeWriter = new FileWriter(path);
                BufferedWriter inStream = new BufferedWriter(obfuscatedCodeWriter)) {
            for (int i = 0; i < codeByLines.size(); i++) {
                Matcher dataTypesMatcher = dataTypesRegex.matcher(codeByLines.get(i).toString());
                if (dataTypesMatcher.lookingAt()) {
                    String forReplace = dataTypesMatcher.group();
                    String[] getName = forReplace.split("(class|int|String|long|boolean|byte|char|short|float|double|void)+((\\s*))");
                    String[] regexCalculationResult = getName[1].split("((\\s)?)+(;|=|\\{|})");
                    code = code.replaceAll(regexCalculationResult[0], randomizedStringForNameReplace());
                } else {
                    System.out.println("!NAMES! Nothing found at line : " + i);
                }
            }
            obfuscatedCodeWriter.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char randomizedCharForNameReplace() {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        char nextChar = (char) (base + rnd % 26);
        return nextChar;
    }

    public static String randomizedStringForNameReplace() {
        String randomizedString = String.valueOf(randomizedCharForNameReplace()) + String.valueOf(randomizedCharForNameReplace());
        return randomizedString;
    }

    public static void operationsObfuscation(String path, ArrayList codeByLines) {
        try (
                FileWriter obfuscatedCodeWriter = new FileWriter(path);
                BufferedWriter inStream = new BufferedWriter(obfuscatedCodeWriter)) {

            for (int i = 0; i < codeByLines.size(); i++) {
                Matcher operationMatcher = operationRegex.matcher(codeByLines.get(i).toString());
                if (operationMatcher.lookingAt()) {
                    String stringForObfuscation = operationMatcher.group();
                    stringForObfuscation = stringForObfuscation.replaceAll("\\s", "");
                    code = code.replaceAll(Pattern.quote(operationMatcher.group()), stringForObfuscation);
                } else {
                    System.out.println("!OPERATIONS! Nothing found at line : " + i);
                }
            }
            obfuscatedCodeWriter.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void multilineCommentObfuscation(String path) {
        try (
                FileWriter obfuscatedCodeWriter = new FileWriter(path);
                BufferedWriter inStream = new BufferedWriter(obfuscatedCodeWriter)) {
            code = code.replaceAll("(\\/+\\*)+((?=((.|\\n)?)+([\\*]+[\\/]))((.|\\n)+\\*+\\/)|$)", "");
            obfuscatedCodeWriter.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void onelineCommentObfuscation(String path, ArrayList codeByLines) {
        try (
                FileWriter obfuscatedCodeWriter = new FileWriter(path);
                BufferedWriter inStream = new BufferedWriter(obfuscatedCodeWriter)) {
            for (int i = 0; i < codeByLines.size(); i++) {
                Matcher onelineCommentMatcher = onelineCommentRegex.matcher(codeByLines.get(i).toString());
                if (onelineCommentMatcher.lookingAt()) {
                    String stringForObfuscation = onelineCommentMatcher.group();
                    stringForObfuscation = stringForObfuscation.replaceAll(Pattern.quote(onelineCommentMatcher.group()), "");
                    code = code.replaceAll(Pattern.quote(onelineCommentMatcher.group()), stringForObfuscation);
                } else {
                    System.out.println("!COMMENTS! Nothing found at line : " + i);
                }
            }
            obfuscatedCodeWriter.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void endOfAStringObfuscation(String path) {
        try (
                FileWriter obfuscatedCodeWriter = new FileWriter(path);
                BufferedWriter inStream = new BufferedWriter(obfuscatedCodeWriter)) {
            code = code.replaceAll("((\\s)?)+;+(((\\s)?)*)", ";");
            obfuscatedCodeWriter.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
