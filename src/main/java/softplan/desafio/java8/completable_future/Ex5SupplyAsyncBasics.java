package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture
 * Static Factory "supplyAsync", usado quando a tarefa devolve um valor.
 * @author Denny R S Vriesman
 *
 */
public class Ex5SupplyAsyncBasics {
	
	public static String getString()  {
		return "Meu Teste xxxx";
	}

	public static void main(String[] args) {
		
		CompletableFuture.supplyAsync(() -> getString()).thenAccept(str -> System.out.println(str));
		
		
	}

}
