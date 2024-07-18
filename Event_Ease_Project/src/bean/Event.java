package bean;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Event {
	private String name;
	private String eventId;
	private String description;
	private String category;
	private String address;
	private LocalDateTime Date;
	private int NumberOfTickets;
	private String TermsAndConditions;
	private double price;
	private String promotionalCode;
	private String companyId;
	@JsonIgnore
	private List<Ticket> listaTickets;

	public Event(String name, String eventId,  String description, String category, String adrdress, LocalDateTime date,
			int numberOfTickets, String termsAndConditions, double price, String promotionalCode, String address) {
		
		this.name = name;
		this.eventId = eventId;
		this.description = description;
		this.category = category;
		this.address = address;
		this.Date = date;
		this.NumberOfTickets = numberOfTickets;
		this.TermsAndConditions = termsAndConditions;
		this.price= price;
		this.promotionalCode = promotionalCode;
		this.listaTickets = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public LocalDateTime getDate() {
		return Date;
	}

	public void setDate(LocalDateTime date) {
		Date = date;
	}

	public int getNumberOfTickets() {
		return NumberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		NumberOfTickets = numberOfTickets;
	}

	public String getTermsAndConditions() {
		return TermsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		TermsAndConditions = termsAndConditions;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price= price;
	}

	public String getPromotionalCode() {
		return promotionalCode;
	}

	public void setPromotionalCode(String promotionalCode) {
		this.promotionalCode = promotionalCode;
	}
	
	public String getCompanyld() {
		return companyId;
	}

	public void setCompanyld(String companyld) {
		this.companyId= companyld;
	}
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	
	
	////////////////////////////////////////////////////////////
	//// Ni idea de si esto va aqui o en el controller
	////////////////////////////////////////////////////////////
	public void addTicket(String ticketId, String info, String userId) {
		if (NumberOfTickets > 0) {
			NumberOfTickets--;
			Ticket t = new Ticket(ticketId, info, userId, eventId);
			listaTickets.add(t);
		} else {
			System.out.println("Limit of tickets reached");
		}
	}
//
//	public boolean checkTicket(String qr) {
//		// TODO Auto-generated method stub
//		boolean valid = false;
//
//		for (int i = 0; i < listaTickets.size(); i++) {
//			if (listaTickets.get(i).getTicketId().equals(qr)) {
//				valid = true;
//				listaTickets.get(i).setValidated(true);
//				listaTickets.remove(i);
//				break;
//			}
//		}
//
//		return valid;
//	}


}