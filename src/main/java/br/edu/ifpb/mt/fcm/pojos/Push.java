package br.edu.ifpb.mt.fcm.pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class Push {

	private String to;

	private String priority;

	private Notification notification;

	@JsonProperty(value = "registration_ids")
	private List<String> registrationIds;

	/**
	 * 
	 * @param priority
	 * @param notification
	 * @param registrationds
	 */
	public Push(String priority, Notification notification, List<String> registrationds) {
		this.priority = priority;
		this.notification = notification;
		this.registrationIds = registrationds;
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

	public List<String> getRegistrationIds() {
		return registrationIds;
	}

	public void setRegistrationIds(List<String> registrationIds) {
		this.registrationIds = registrationIds;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
