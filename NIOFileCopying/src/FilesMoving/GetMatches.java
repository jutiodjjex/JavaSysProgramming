package FilesMoving;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

class GetMatches extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;

    /**
     *
     * Метод ищет совпадения с шаблоном в локальной директории.
     *
     * @param pattern - шаблон расширения, указанный в мейне.
     */
    GetMatches(String pattern) {
        try {
            matcher = FileSystems.getDefault().getPathMatcher(pattern);
        } catch (IllegalArgumentException iae) {
            System.err.println("Invalid pattern");
            System.exit(1);
        }
    }

    /**
     *
     * Метод содержит в себе действия, которые необходимо произвести
     * при находке нужного файла.
     * Метод вызывает метод find
     *
     * @param path - путь к файлу.
     * @param fileAttributes - атрибуты директории.
     * @return
     */
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }

    /**
     *
     * Метод для перемещения найденного файла в папку назначения.
     * Посредством метода fileInfo() выводит информацию о файле.
     *
     * @param path - путь к файлу.
     */
    private void find(Path path) {
        Path name = path.getFileName();
        if (matcher.matches(name)) {
            fileInfo(name);
            Path destPath = Paths.get( "C:\\Users\\PryaN\\IdeaProjects\\NIOFileCopying\\DestinationFolder\\" + name.getFileName());
            try {
                Files.move(name, destPath);
                System.out.println("File " + path.getFileName() + " was successfully moved to " + destPath.getParent() + " folder. \n \n");
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    /**
     *
     * Метод выводит то, что файл найден, его имя, размер и владельца.
     *
     * @param name - путь к файлу.
     */
    private void fileInfo(Path name){
        try {
            System.out.println("File found: " + name.getFileName());
            System.out.println("Size: " + Files.getAttribute(name, "size"));
            System.out.println("Owner: " + Files.getOwner(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
