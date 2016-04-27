package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * CompletableFuture
 * Exemplo de Transformação
 * @author root
 *
 */
public class Ex7Transformation {
	
	static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public static String getString() throws Exception  {
		return "Meu Teste";
	}

	public static void main(String[] args) throws InterruptedException {
		
		final CompletableFuture<String> anotherPromisse = new CompletableFuture<>();
		
		CompletableFuture.runAsync(() -> {
			try {
				anotherPromisse.complete(getString());
				
			} catch (Exception e) {
				anotherPromisse.completeExceptionally(e);
			}
		}, pool);
		
		anotherPromisse.thenApply(str ->  str.length()).thenApplyAsync(i -> i * 2).handle((str, ex) -> {
			if (ex != null) {
				System.out.println(ex.getMessage());
			} else {
				System.out.println(str);
				
			}
			
			return null;
		});
		
		
		
	}

}





