package FilesMoving;

import java.io.IOException;
import java.nio.file.*;


/**
 *  Программа для того, чтобы находить нужные файлы в локальной директории
 *  по расширению. В данном случае используется расширение файлов .jpg
 *  После нахождения нужного файла, программа перемещает его в заранее заданную директорию.
 *
 * @author P.V.V. 16IT18k
 */
public class Main {
    public static void main(String[] args) {
        Path startPath = Paths.get("C:\\Users\\PryaN\\IdeaProjects\\NIOFileCopying");

        //Строка с glob-шаблоном, ищем файлы с раширением .jpg
        String pattern = "glob:*.jpg";


        try {
            Files.walkFileTree(startPath, new GetMatches(pattern));
            System.out.println("File moving completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
