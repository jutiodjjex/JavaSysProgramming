package FileMoving;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;


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

        int moveCount = 0;

        System.out.println("Введите папку, из которой нужно скопировать файлы: ");
        Path sourceDirectory = Paths.get(scan.nextLine());

        System.out.println("Введите папку, в которую нужно скопировать файлы: ");
        Path destinationDirectory = Paths.get(scan.nextLine());

        moveCount = fileMovingNCounting(sourceDirectory, destinationDirectory, moveCount);

        System.out.println(moveCount + " files was successfully moved to " + destinationDirectory + " folder." );
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
     * @param moveCount - кол-во перемещённых файлов.
     * @return - возвращает кол-во перемещённых файлов после окончания итераций цикла.
     */
    static private int fileMovingNCounting(Path srcDirectory, Path destDirectory, int moveCount){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(srcDirectory)) {
            for (Path entry : stream) {
                moveCount++;
                Files.move(entry, Paths.get(destDirectory.toString() + "\\" + entry.getFileName()));
                System.out.println("File \"" + entry.getFileName() + "\" \nWas moved to \"" + destDirectory.getParent() + "\" folder \n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moveCount;
    }
}

