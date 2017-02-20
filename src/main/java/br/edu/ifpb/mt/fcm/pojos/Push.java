package br.edu.ifpb.mt.fcm.pojos;

import java.util.List;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class Push {

	private String to;

	private String priority;

	private Notification notification;

	private List<String> registration_ids;

	/**
	 * 
	 * @param priority
	 * @param notification
	 * @param registration_ids
	 */
	public Push(String priority, Notification notification, List<String> registration_ids) {
		this.priority = priority;
		this.notification = notification;
		this.registration_ids = registration_ids;
	}

	/**
	 * 
	 * @param to
	 * @param priority
	 * @param notification
	 */
	public Push(String to, String priority, Notification notification) {
		this.to = to;
		this.priority = priority;
		this.notification = notification;
	}

	/**
	 * 
	 */
	public Push() {

	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public List<String> getRegistration_ids() {
		return registration_ids;
	}

	public void setRegistration_ids(List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
