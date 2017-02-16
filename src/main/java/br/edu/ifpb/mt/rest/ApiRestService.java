package br.edu.ifpb.mt.rest;

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
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class ApiRestService {
	
	@Autowired
	private PushNotificationService pushNotification;
	
	@Autowired
	private DoadorRepositoty doadorRepositoty;
	
	@RequestMapping(value = "/doador", method = RequestMethod.POST)
	public ResponseEntity<Doador> saveDoador(@RequestBody Doador doador) {
		
		Doador doadorSaved = doadorRepositoty.save(doador);
		
		return new ResponseEntity<Doador>(doadorSaved, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/pushAll", method = RequestMethod.GET)
	public ResponseEntity<?> pushAll() {
				
		return new ResponseEntity<Doador>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public ResponseEntity<?> push() {
		
		
		List<Doador> doadores = doadorRepositoty.findAll();
		
		for (Doador doador : doadores) {
			Notification notification = new Notification("default", "Ajude Mais", "Teste");
			Push push = new Push(doador.getTokenFCM(), "high", notification);			
			pushNotification.sendNotification(push);
		}
				
		return new ResponseEntity<Doador>(HttpStatus.CREATED);
	}
}
