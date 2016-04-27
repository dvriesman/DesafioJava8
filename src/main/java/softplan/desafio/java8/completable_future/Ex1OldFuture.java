package softplan.desafio.java8.completable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future
 * Exemplo do uso de Future e limitação: Métodos bloqueantes.
 * @author Denny R S Vriesman
 *
 */
public class Ex1OldFuture {

	private static final ExecutorService pool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		long start = System.nanoTime();
		
		Callable<String> task01Callable = doMyTask("t1");
		Callable<String> task02Callable = doMyTask("tarefa 2");
		
		Future<String> task01Future = pool.submit(task01Callable);
		Future<String> task02Future = pool.submit(task02Callable);
		
		while(!task01Future.isDone() || !task02Future.isDone()) {
			System.out.println("Em processamento");
		}
		
		System.out.println(task01Future.get());
		
		System.out.println("depois do primeiro get");
		
		System.out.println(task02Future.get());
		
		long end = System.nanoTime();
		
		System.out.println("Tempo de execução " + ((end - start) / 1.0E9));
		
		pool.shutdown();
		
	}
	
	public static Callable<String> doMyTask(String name) {
		
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "Tarefa processada: " + name;
			}
		};
		
	}


}


/*

*/