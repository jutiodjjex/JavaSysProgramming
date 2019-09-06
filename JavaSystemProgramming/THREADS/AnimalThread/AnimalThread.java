package AnimalThread;
import java.lang.InterruptedException;

/*
 * Программа, которая запускает два потока и
 * устраивает гонки между ними. Каждые 100000 метров
 * меняет приоритет с 1 на 10 и обратно для видимого контраста скорости от смены приоритета.
 * @author Pronichkin Vyacheslav 16IT18k
 */
 
public class AnimalThread extends Thread {
	AnimalThread(String name, int priority){
		setName(name);
		setPriority(priority);
	}
	
	//Метод Run, в нем цикл для потока и смена приоритета потока.
	
	@Override
	public void run(){
		System.out.printf("%s. Приоритет: %s \n", getName(), getPriority());
		System.out.println();
		
		for(int i = 0; i <= 500000; i++){
			if(i % 10000 == 0){
				System.out.printf("%s прошел %d метров \n", getName(), i);
			}
			if( i % 100000 == 0){
				if(getPriority() == 10){
					setPriority(1);
					System.out.printf("%s приоритет = %d \n", getName(), getPriority());
				} else {
					setPriority(10);
                    System.out.printf("%s приоритет = %d \n", getName(), getPriority());	
				}
			}				
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
	}
}