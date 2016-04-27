package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture
 * Exemplo com Thread criada a moda tradicional
 * @author Denny R S Vriesman
 *
 */
public class Ex3ManualThread {
	
	public static String getString() throws Exception {
		//throw new Exception("Meu erro");
		return "Meu Teste";
	}

	public static void main(String[] args) {
		
		final CompletableFuture<String> completableFuture = new CompletableFuture<>();
		
		new Thread() {
			@Override
			public void run() {
				try {
					
					completableFuture.complete(getString());
					
				} catch (Exception e) {
					
					completableFuture.completeExceptionally(e);
				}
				
			}
		}.start();
		
		completableFuture.thenAccept(str -> System.out.println("Em tempo real:" + str));
		
		completableFuture.exceptionally(ex -> {
			System.out.println(ex.getMessage());
			return null;
			
		}  );
		
		System.out.println("fim.");
		
	}

}
