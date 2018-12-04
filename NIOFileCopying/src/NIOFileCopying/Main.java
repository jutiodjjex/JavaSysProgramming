package NIOFileCopying;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {

        Path destinationTargetPath = Paths.get("C:\\Users\\PryaN\\IdeaProjects\\NIOFileCopying\\ExampleDirectoryForDestination");
        int nameCounting = -1;

        for (int i = 0; i < 6; i++) {
            nameCounting++;
            String nameCountingString = "C:\\Users\\PryaN\\IdeaProjects\\NIOFileCopying\\example" + nameCounting + ".jpg";
            Path sourceTargetPath = Paths.get(nameCountingString);
            try {
                Files.move(sourceTargetPath, destinationTargetPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("Source file %s copied to %s copied successfully \n", sourceTargetPath.getFileName(), destinationTargetPath.toAbsolutePath());
        }
    }
}

