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

    static private void saveNameOfTransferedFile(String nameOfTheTransferedFile){
        try(FileWriter writer = new FileWriter("C:\\Users\\PryaN\\IdeaProjects\\JavaSysProgramming\\NIOFileMoving\\src\\FileMoving\\MovedFiles.txt", true)) {

            writer.write(nameOfTheTransferedFile);
            writer.append('\n');
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static private void movedFilesNotify(){

        countOfTransferedFiles();

        try(FileReader reader = new FileReader("C:\\Users\\PryaN\\IdeaProjects\\JavaSysProgramming\\NIOFileMoving\\src\\FileMoving\\MovedFiles.txt"))
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

    static private void countOfTransferedFiles(){
        int filesMovedCount = 0;
        try(FileReader reader = new FileReader("C:\\Users\\PryaN\\IdeaProjects\\JavaSysProgramming\\NIOFileMoving\\src\\FileMoving\\MovedFiles.txt");
            FileWriter writer = new FileWriter("C:\\Users\\PryaN\\IdeaProjects\\JavaSysProgramming\\NIOFileMoving\\src\\FileMoving\\MovedFiles.txt", true))
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

