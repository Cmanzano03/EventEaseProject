package bean;


public class Cashier extends Profile {
	private Event currentEvent;	

	public Cashier(String id, String password, String email, int tlf_number) {
		super(id, password, email, tlf_number);
	}
	
	public boolean ReadQr (String qr) {
		boolean valid = false;
		
		if(currentEvent.checkTicket(qr)) {
			valid = true;
		}
		
		return valid;
	}
	public void SetEvent (Event e) {
		currentEvent = e;
	}

}
