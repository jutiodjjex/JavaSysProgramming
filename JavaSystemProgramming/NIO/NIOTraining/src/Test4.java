
import java.io.IOException;
import java.nio.file.*;

class Test4 {
    public static void main(String[] args) throws IOException {

        //Создается объект класса Path.
        Path path1 = Paths.get("Test");

        //Создается объект класса Path.
        Path path2 = Paths.get("C:\\Users\\PryaN\\IdeaProjects\\NIOTraining\\Test");

        System.out.println("Files.isSameFile(path1, path2) is: "
                + Files.isSameFile(path1, path2));
    }
}
