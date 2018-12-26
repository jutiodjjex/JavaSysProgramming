package com.github.jutiodjjex;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.lang.String;


/**
 * Программа для нахождения файлов в заданной директории
 * и перемещение последних в другую заданную директорию.
 * Выводит кол-во перемещённых файлов.
 *
 * Код выхода 1 - (Exit code 1) - Обозначает то, что программа выключилась при ошибке на стадии переноса файлов.
 *
 * @author P.V.V. 16IT18K
 */

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static final String MOVE_INFORMATION_FILE = "C:\\Users\\PryaN\\IdeaProjects\\NIOFileMoving\\src\\com\\github\\jutiodjjex\\MovedFiles.txt";
    static private String[] pathsForTransfering = {"", ""};

    public static void main(String[] args) {

        pathsEnterOneByOne();
        fileMoving();
        showInfoAboutMovedFiles();

    }


    /**
     *
     * Метод находит все файлы, которые находятся в директории,
     * перемещает найденные файлы в другую директорию,
     * указанную в аргументе метода, при этом считая
     * кол-во перемещённых файлов, выводит имена перемещенных файлов.
     *
     */
    static private void fileMoving(){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(pathsForTransfering[0]))) {
            for (Path entry : stream) {
                Files.move(entry, Paths.get(pathsForTransfering[1] + "\\" + entry.getFileName()));
                String transferedFileName = "File \"" + entry.getFileName() + "\" was moved.";
                saveNameOfTransferedFile(transferedFileName);

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Files are not found.");
            System.exit(1);
        }
    }


    /**
     *
     * Метод записывает имя перемещённого файла в .txt файл с данными о перемещенных файлах.
     *
     * @param nameOfTheTransferedFile - Строковое значение о имени перемещенного файла.
     */
    static private void saveNameOfTransferedFile(String nameOfTheTransferedFile){
        try(FileWriter writer = new FileWriter(MOVE_INFORMATION_FILE, true)) {

            writer.write(nameOfTheTransferedFile);
            writer.append('\n');
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * Метод выводит информацию о перемещенных файлах:
     * имена перемещенных файлов и кол-во перемещенных файлов.
     *
     * Метод вызывает другой метод countOfTransferedFiles() для того, чтобы сосчитать кол-во
     * перемещенных файлов.
     *
     * Информация о перемещенных файлах берётся из .txt файла, в которую записывается информация о перемещении.
     */
    static private void showInfoAboutMovedFiles(){

        countOfTransferedFiles();

        try(FileReader reader = new FileReader(MOVE_INFORMATION_FILE))
        {
            int eachCharReader;
            while((eachCharReader = reader.read()) != -1){
                System.out.print((char)eachCharReader);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * Метод считает кол-во перемещенных файлов и записывает их в .txt файл
     * с информацией о перемещенных файлах.
     *
     * Если ни один файл не перемещён, то в .txt файле вывода будет написано, что файлов
     * перемещено: 0.
     */
    static private void countOfTransferedFiles(){
        int filesMovedCount = 0;
        try(FileReader reader = new FileReader(MOVE_INFORMATION_FILE);
            FileWriter writer = new FileWriter(MOVE_INFORMATION_FILE, true))
        {
            int eachCharReader;
            while((eachCharReader = reader.read()) != -1){
                if(eachCharReader == '\n'){
                    filesMovedCount++;
                }
            }
            writer.write("Files moved: " + filesMovedCount);
            writer.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * Метод для ввода данных о местоположении папки с файлами и папки-приемника.
     *
     * Использует метод handlingEnteringData() для выявления несуществующей папки.
     *
     */
    static private void pathsEnterOneByOne() {
        String[] folderRequest = {"из которой", "в которую"};
        for (int i = 0; i <= 1; i++) {
            do {
                handlingEnteringData(pathsForTransfering[i]); //Проверяет наличие такой директории, в случае чего выдает ошибку
                System.out.println("Введите папку, " + folderRequest[i] + " нужно переместить файлы: ");
                pathsForTransfering[i] = scan.nextLine();
            } while (!(ifExists(pathsForTransfering[i])));
        }
    }

    /**
     *
     * Метод для проверки того, существует ли введённый пользователем путь.
     *
     * @param existableDirectory - директория, подлежащая проверке.
     *
     */
    static private boolean ifExists(String existableDirectory) {

        return Files.exists(Paths.get(existableDirectory), LinkOption.NOFOLLOW_LINKS);

    }

    /**
     *
     * Метод для вывода ошибки о том, что введённая директория не найдена.
     *
     * Внутри метода используется метод ifExists() для проверки существования директории.
     */
    static private void handlingEnteringData(String enterDataArray){
        System.out.println(enterDataArray);

        if((!(ifExists(enterDataArray))) && (enterDataArray != "")){ //Если такая папка не существует и её путь не пустой - возвращается false.
            System.out.println("This directory is not exists. \n Try again.");
        }

    }
}


