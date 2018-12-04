
import java.nio.file.*;

class Test3 {
    public static void main(String[] args) {

        //Создается объект класса Path.
        Path path1 = Paths.get("Test");

        //Создается объект класса Path.
        Path path2 = Paths.get("C:\\Games\\Test1\\Test");

        //Происходит сравнение первого пути со вторым. Второй путь выступает
        //в виде аргумента для метода compareTo(Path).
        System.out.println("(path1.compareTo(path2) == 0) is: "
                + (path1.compareTo(path2) == 0));

        //
        System.out.println("path1.equals(path2) is: " + path1.equals(path2));

        System.out.println("path2.equals(path1.toAbsolutePath()) is "
                + path2.equals(path1.toAbsolutePath()));

        System.out.println(path1.toAbsolutePath());
    }
}
