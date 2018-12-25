package FileMoving;

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
 * @author P.V.V. 16IT18K
 */

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static final String MOVE_INFORMATION_FILE = "C:\\Users\\PryaN\\IdeaProjects\\JavaSysProgramming\\NIOFileMoving\\src\\FileMoving\\MovedFiles.txt";

    public static void main(String[] args) {


        System.out.println("Введите папку, из которой нужно скопировать файлы: ");
        String sourceDirectory = scan.nextLine();

        System.out.println("Введите папку, в которую нужно скопировать файлы: ");
        String destinationDirectory = scan.nextLine();

        fileMoving(sourceDirectory, destinationDirectory);
        movedFilesNotify();

    }


    /**
     *
     * Метод находит все файлы, которые находятся в директории,
     * перемещает найденные файлы в другую директорию,
     * указанную в аргументе метода, при этом считая
     * кол-во перемещённых файлов, выводит имена перемещенных файлов.
     *
     *
     * @param srcDirectory - путь к директории, откуда копируются файлы.
     * @param destDirectory - путь к директории, куда копируются файлы.
     */
    static private void fileMoving(String srcDirectory, String destDirectory){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(srcDirectory))) {
            for (Path entry : stream) {
                Files.move(entry, Paths.get(destDirectory + "\\" + entry.getFileName()));
                String transferedFileName = "File \"" + entry.getFileName() + "\" was moved.";
                saveNameOfTransferedFile(transferedFileName);

            }
        } catch (IOException e) {
            e.printStackTrace();
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
    static private void movedFilesNotify(){

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
}

