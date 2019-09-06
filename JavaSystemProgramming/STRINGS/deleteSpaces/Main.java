import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Scanner;

import static java.lang.Math.toIntExact;

public class Main {

    static Pattern getSpacesRegex = Pattern.compile("((\\s)+)"); //Инициализация регулярного выражения

    static String text; //Обьявление переменной с текстом


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String pathTarget = getTargetPath(scan); //Инициализация входного пути
        String pathDestination = getDestinationPath(scan); //Инициализация конечного пути

        ArrayList codeByLines = new ArrayList(); //Объявление переменной для получения текста построчно
        codeByLines = textInitializationByLies(pathTarget); //Инициализация переменной для получения текста построчно
        deleteSpaces(pathDestination); //Удаляем пробелы
    }

    /**
     * @param path Путь к исходному файлу с текстом.
     * @return - Возвращает полный текст из файла, считывая его построчно.
     *              С помощью этого метода мы построчно инициализируем текст в глобальную переменную text
     */
    public static ArrayList textInitializationByLies(String path) {
        ArrayList textByLines = new ArrayList();
        try
                (FileReader textReader = new FileReader(path);
                 BufferedReader inStream = new BufferedReader(textReader)) {

            int linesCount = getAmountOfLines(path);

            for (int i = 0; i < linesCount; i++) {
                textByLines.add(inStream.readLine());
                text = text + "\n" + textByLines.get(i);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textByLines;
    }

    /**
     * @param path Путь к исходному тексту
     * @return возвращает кол-во считанных строк
     *            С помощью этого метода мы получаем кол-во строк, находящихся в исходном файле.
     */
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

    /**
     * @param path Путь к конечному файлу, куда запишется результат работы метода
     *             С помощью этого метода мы находим любое кол-во идущих подряд пробелов и заменяем их на один.
     */
    public static void deleteSpaces(String path) {
        try (
                FileWriter obfuscatedCodeWriter = new FileWriter(path);
                BufferedWriter inStream = new BufferedWriter(obfuscatedCodeWriter)) {
            text = text.replaceAll(getSpacesRegex.toString(), " ");
            obfuscatedCodeWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTargetPath(Scanner scan){
        System.out.println("Введите абсолютный путь до файла с текстом.");
        return scan.nextLine();
    }

    public static String getDestinationPath(Scanner scan){
        System.out.println("Введите абсолютный путь до файла, куда запишется результат.");
        return scan.nextLine();
    }
}
