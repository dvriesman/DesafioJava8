package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture
 * Exemplo de Composição, encadeando Futures.
 * @author Denny R S Vriesman
 *
 */
public class Ex8ComposeIt {
	
	static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public static int compute(int value) {
		return value * 10;
	}

	public static void main(String[] args) throws InterruptedException {
		
		CompletableFuture.supplyAsync(() -> {
			return compute(10);
		}).thenCompose(i -> CompletableFuture.supplyAsync(() -> i * 2)).
		thenAccept(i -> System.out.println(i.toString()));
		
		
	};
	

}
