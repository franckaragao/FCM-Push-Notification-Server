package br.edu.ifpb.mt.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.mt.fcm.PushNotificationService;
import br.edu.ifpb.mt.fcm.pojos.Notification;
import br.edu.ifpb.mt.fcm.pojos.Push;
import br.edu.ifpb.mt.model.Doador;
import br.edu.ifpb.mt.repository.DoadorRepositoty;

/**
 * 
 * Classe de endpoits básicos para testes de notificações com cliente Android e
 * testes de envios de notificações.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class ApiRestService {

	@Autowired
	private PushNotificationService pushNotification;

	@Autowired
	private DoadorRepositoty doadorRepositoty;

	/**
	 * Salva usuário cliente Android com token de registro do firebase
	 * 
	 * @param doador
	 * @return
	 */
	@RequestMapping(value = "/doador", method = RequestMethod.POST)
	public ResponseEntity<Doador> saveDoador(@RequestBody Doador doador) {
		System.out.println(doador);
		Doador doadorSaved = doadorRepositoty.save(doador);

		return new ResponseEntity<Doador>(doadorSaved, HttpStatus.CREATED);

	}

	/**
	 * Envia para todos os dispositivos
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pushAll", method = RequestMethod.GET)
	public ResponseEntity<?> pushAll() {

		List<String> tokens = new ArrayList<>();
		List<Doador> doadores = doadorRepositoty.findAll();

		doadores.forEach(d -> tokens.add(d.getTokenFCM().getToken()));
		
		System.out.println(tokens);

		Notification notification = new Notification("default", "Ajude Mais", "Teste");
		Push push = new Push("high", notification, tokens);
		pushNotification.sendNotification(push);

		return new ResponseEntity<Doador>(HttpStatus.CREATED);
	}

	/**
	 * Envia para único dispositivo
	 * 
	 * @return
	 */
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public ResponseEntity<?> push() {

		List<Doador> doadores = doadorRepositoty.findAll();

		Notification notification = new Notification("default", "Ajude Mais", "Teste");
		Push push = new Push(doadores.get(0).getTokenFCM().getToken(), "high", notification);
		pushNotification.sendNotification(push);

		return new ResponseEntity<Doador>(HttpStatus.CREATED);
	}
}
