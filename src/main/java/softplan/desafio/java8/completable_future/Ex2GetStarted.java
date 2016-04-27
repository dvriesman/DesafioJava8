package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture
 * Exemplo de Construção básica
 * @author Denny R S Vriesman
 *
 */
public class Ex2GetStarted {
	
	public static String fazerAlgumaCoisa() {
		return "Minha mensagem de processamento";
	}
	
	public static void main(String args[]) {
		
		CompletableFuture<String> c1 = new CompletableFuture<>();
		
		c1.complete(fazerAlgumaCoisa());
		
		c1.thenAccept(i -> System.out.println(i));
		
		System.out.println("Fim");
		
	}


}


