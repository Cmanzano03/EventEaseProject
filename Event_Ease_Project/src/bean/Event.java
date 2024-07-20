package bean;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Event {
	private String name;
	private Integer eventId;
	private String description;
	private String category;
	private String address;
	private LocalDateTime Date;
	private int NumberOfTickets;
	private String TermsAndConditions;
	private double price;
	private String promotionalCode;
	private Integer companyId;
	private boolean soldedOut;
	@JsonIgnore
	private List<Ticket> listaTickets;
	
	public Event() {
		
	}
	public Event(String name, Integer  eventId,  String description, String category, String adrdress, LocalDateTime date,
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
		soldedOut = false;
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
	
	public void decreMentTickets() {
		this.NumberOfTickets--;
		if (NumberOfTickets == 0) {
			setSoldedOut(true);
		}
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
	
	public Integer  getCompanyld() {
		return companyId;
	}

	public void setCompanyld(Integer companyld) {
		this.companyId= companyld;
	}
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public boolean isSoldedOut() {
		return soldedOut;
	}
	public void setSoldedOut(boolean soldedOut) {
		this.soldedOut = soldedOut;
	}
	

}