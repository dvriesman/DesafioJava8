package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture
 * Simplificando com "handle" ao invés de "thenAccept" e "exceptionally"
 * @author Denny R S Vriesman
 *
 */
public class Ex4HandleIt {
	
	public static String getString() throws Exception {
		//throw new Exception("Error");
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
		
		completableFuture.handle((str, ex) -> { 
			
			if (ex == null) {
				System.out.println(str);
			} else {
				System.out.println(ex.getMessage());
			}
			return null;
		
		});
		
		
		
		
	}

}
