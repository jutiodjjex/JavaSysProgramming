package AnimalThread;

/*
 * Программа, которая запускает два потока и
 * устраивает гонки между ними. Каждые 100000 метров
 * меняет приоритет с 1 на 10 и обратно для видимого контраста скорости от смены приоритета.
 * @author Pronichkin Vyacheslav 16IT18k
 */

 //Мейн класс, создает два параллельных потока и запускает их.
public class Main{
	public static void main(String[]args){
		new AnimalThread("Turtle", 1).start();
		new AnimalThread("Rabbit", 10).start();
	}
}