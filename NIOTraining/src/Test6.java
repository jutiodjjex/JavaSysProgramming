import java.nio.file.*;

class Test6 {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\PryaN\\IdeaProjects\\NIOTraining\\src\\Test5.java");

        System.out.printf("Readable: %b, Writable: %b, Executable: %b ",
                Files.isReadable(path), Files.isWritable(path),
                Files.isExecutable(path));
    }
} 