package bean;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Event {
	private String name;
	private String Description;
	private String Category;
	private String Address;
	private LocalDateTime Date;
	private int NumberOfTickets;
	private String TermsAndConditions;
	private double Price;
	private String PromotionalCode;

	List<Ticket> listaTickets;

	public Event(String name, String description, String category, String address, LocalDateTime date,
			int numberOfTickets, String termsAndConditions, double price, String promotionalCode) {
		super();
		this.name = name;
		Description = description;
		Category = category;
		Address = address;
		Date = date;
		NumberOfTickets = numberOfTickets;
		TermsAndConditions = termsAndConditions;
		Price = price;
		PromotionalCode = promotionalCode;
		this.listaTickets = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getPromotionalCode() {
		return PromotionalCode;
	}

	public void setPromotionalCode(String promotionalCode) {
		PromotionalCode = promotionalCode;
	}

	////////////////////////////////////////////////////////////
	//// Ni idea de si esto va aqui o en el service
	////////////////////////////////////////////////////////////
	public void addTicket(String ticketId, String info, String userId) {
		if(NumberOfTickets > 0) {
			NumberOfTickets--;
			Ticket t = new Ticket(ticketId, info, userId);
			listaTickets.add(t);
		}
		else {
			System.out.println("Limit of tickets reached");
		}
	}
	
	public boolean checkTicket(String qr) {
		// TODO Auto-generated method stub
		boolean valid = false;
		
		for (int i = 0; i < listaTickets.size(); i++) {
			if(listaTickets.get(i).getTicketId().equals(qr)) {
				valid = true;
				listaTickets.get(i).setValidated(true);
				listaTickets.remove(i);
				break;
			}
		}

		return valid;
	}
}