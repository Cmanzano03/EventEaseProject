package bean;

public class Ticket {
	String ticketId;
	String info;
	boolean validated; 
	String userId;
	
	public Ticket(String ticketId, String info, String userId) {
		this.ticketId = ticketId;
		this.info = info;
		this.userId = userId;
		this.validated = false;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
