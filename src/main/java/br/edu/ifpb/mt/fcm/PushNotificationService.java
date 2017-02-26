package br.edu.ifpb.mt.fcm;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.ifpb.mt.fcm.pojos.Push;
import br.edu.ifpb.mt.filters.HeaderRequestInterceptor;

/**
 * 
 * 
 * <p>
 * <b> Push Notification Service </b>
 * </p>
 *
 * <p>
 * Service para envio de mensagens para o servidor do firebase cloud messaging
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */

@Service
public class PushNotificationService {

	private static final String FCM_SERVER_KEY = "xxxxxxxxxxxxxxx4FgdTe0dAKwbQw8Dw9BESEQ4gViVERTUS0uT06C7DZ2GS-tDxy-kV";
	private static final String FCM_API = "https://fcm.googleapis.com/fcm/send";

	/**
	 * 
	 * @param push
	 * @return
	 */
	
	public FirebaseResponse sendNotification(Push push) {

		HttpEntity<Push> request = new HttpEntity<>(push);

		CompletableFuture<FirebaseResponse> pushNotification = this.send(request);
		CompletableFuture.allOf(pushNotification).join();

		FirebaseResponse firebaseResponse = null;
		
		try {
			firebaseResponse = pushNotification.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return firebaseResponse;
}
	
	/**
	 * Envia notificação para API do firebase
	 * 
	 * Método utiliza CompletableFuture com @Async para realizar 
	 * chamada assicrona na API do Firebase
	 * 
	 * @param entity
	 * @return
	 */
	@Async
	private CompletableFuture<FirebaseResponse> send(HttpEntity<Push> entity) {

		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FCM_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);

		FirebaseResponse firebaseResponse = restTemplate.postForObject(FCM_API, entity, FirebaseResponse.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}
}
