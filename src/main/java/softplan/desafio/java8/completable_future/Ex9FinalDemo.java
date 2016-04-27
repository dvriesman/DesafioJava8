package softplan.desafio.java8.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture
 * Exemplo de aplicação, 
 * Uso de Combinação, rodando duas tarefas assincronamente, 
 * combinando o resultado e recuperando resposta num único callback.
 * @author Denny S V Vriesman
 *
 */
public class Ex9FinalDemo {
	
	static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public static CompletableFuture<Boolean> checkIP(String ip) {
		return CompletableFuture.supplyAsync(() -> {
			return "192.168.0.2".equals(ip);
		},pool);
	}

	public static CompletableFuture<Boolean> checkLogin(String user, String password) {
		return CompletableFuture.supplyAsync(() -> {
			return user == "desafio" && password == "java";
		}, pool);
		
	}
	
	public static String combinedCheck(Boolean login, Boolean ip) {
		if (login && ip) {
			return "acesso permitido!";
		} else{
			return "acesso negado!";
		}
	}
	
	public static void main (String... args) {
		
		CompletableFuture<Boolean> checkLogin = checkLogin("desafio", "java");
		CompletableFuture<Boolean> checkIp = checkIP("192.168.0.2");
		
		
		checkLogin.thenCombine(checkIp, (a,b) ->  combinedCheck(a,b)).
			thenAccept(str -> System.out.println(str));
		
	}

}
