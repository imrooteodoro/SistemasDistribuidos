package thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Questao1 {
	public static void main(String[] args) {
		
		
		 List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());

	        Thread[] threads = new Thread[5];

	        for (int i = 0; i < threads.length; i++) {
	            threads[i] = new Thread(() -> {
	                Random random = new Random();
	                for (int j = 0; j < 200; j++) {
	                    numbers.add(random.nextInt(2001));
	                }
	            });
	        }

	        for (Thread thread : threads) {
	            thread.start();
	        }

	        for (Thread thread : threads) {
	            try {
	                thread.join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        Collections.sort(numbers, Collections.reverseOrder());

	        for (Integer number : numbers) {
	            System.out.println(number);	        }
	
	}
}