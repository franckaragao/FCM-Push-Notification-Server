package br.edu.ifpb.mt.fcm.pojos;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class Push {

	private String to;

	private String priority;

	private Notification notification;

	public Push(String to, String priority, Notification notification) {
		this.to = to;
		this.priority = priority;
		this.notification = notification;
	}

	public Push() {

	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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
}
