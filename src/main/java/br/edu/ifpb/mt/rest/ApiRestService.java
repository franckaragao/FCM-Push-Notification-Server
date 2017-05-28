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
import br.edu.ifpb.mt.model.Person;
import br.edu.ifpb.mt.repository.PersonRepositoty;

/**
 * 
 * Rest services for tests.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class ApiRestService {

	/**
	 * 
	 */
	@Autowired
	private PushNotificationService pushNotification;

	/**
	 * 
	 */
	@Autowired
	private PersonRepositoty personRepositoty;

	/**
	 * save entity with token FCM from app android
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<Person> saveProject(@RequestBody Person person) {

		Person personSaved = personRepositoty.save(person);

		return new ResponseEntity<Person>(personSaved, HttpStatus.CREATED);

	}

	/**
	 * send notificatin to all
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pushAll", method = RequestMethod.GET)
	public ResponseEntity<?> pushAll() {

		List<String> tokens = new ArrayList<>();
		List<Person> persons = personRepositoty.findAll();

		persons.forEach(p -> tokens.add(p.getTokenFCM().getToken()));

		Notification notification = new Notification("default", "My App", "Test");
		Push push = new Push("high", notification, tokens);
		pushNotification.sendNotification(push);

		return new ResponseEntity<Person>(HttpStatus.CREATED);
	}

	/**
	 * Send to singleton app
	 * 
	 * @return
	 */
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public ResponseEntity<?> push() {

		personRepositoty.findFirstByOrderByName().ifPresent(p -> {
			Notification notification = new Notification("default", "My app", "Teste");
			Push push = new Push(p.getTokenFCM().getToken(), "high", notification);
			pushNotification.sendNotification(push);
		});
		
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
}
