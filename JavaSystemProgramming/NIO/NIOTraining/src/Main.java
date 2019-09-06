
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {


        //Пример строки создания объекта Path пути для запуска в Windows
        Path testFilePath = Paths.get("C:\\Games\\Test\\Test1\\3.txt");

        //Вывод инормации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: " + testFilePath.getParent());

        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }
}