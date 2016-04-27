package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture
 * Static Factory "runAssync", usado quando a tarefa NÃO devolve um valor.
 * @author Denny R S Vriesman
 *
 */
public class Ex6RunAsyncBasics {
	
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
		
		anotherPromisse.handle((str, ex) -> {
			if (ex != null) {
				System.out.println(ex.getMessage());
			} else {
				System.out.println(str);
				
			}
			
			return null;
		});
		
		
		
	}

}
