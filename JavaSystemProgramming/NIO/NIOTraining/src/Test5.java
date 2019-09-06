import java.nio.file.*;

class Test5 {
    public static void main(String[] args) {
        //Проверка для файла
        Path path = Paths.get("C:\\Users\\PryaN\\IdeaProjects\\NIOTraining\\src\\Test5.java");

        //Проверка для дериктории
        //Path path = Paths.get("C:\\Users\\PryaN\\IdeaProjects\\NIOTraining\\src");

        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The file/directory " + path.getFileName()
                    + " exists");
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                System.out.println(path.getFileName() + " is a directory");
            } else {
                System.out.println(path.getFileName() + " is a file");
            }
        } else {
            System.out.println("The file/directory " + path.getFileName() + " does not exist");
        }
    }
}
