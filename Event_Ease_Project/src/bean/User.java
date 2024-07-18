package bean;

import java.util.List;

import exceptions.notFoundElementException;

import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User extends Profile {
	
//    @JsonIgnore
//	private List <Ticket> history;
    @JsonIgnore
	private List <Ticket> currentEvents; 
	

	public User(String id, String password, String email, int tlf_number) {
		super(id, password, email, tlf_number);
//		history = new ArrayList<Ticket>();
		currentEvents = new ArrayList<Ticket>();
	}
	
//	public void addTicketHistory(Ticket ticket){
//		history.add(ticket);
//	}
//	
//	public Ticket getTicketHistory(int index) {
//		return history.get(index);
//	}
//	
//	public Ticket getTicketHistory(String id) throws notFoundElementException {
//		Ticket ticket = null;
//		for (int i = 0; i < history.size(); i++) {
//			ticket = history.get(i);
//			if(ticket.getTicketId().equals(id)) {
//				return ticket;
//			}
//		}
//		throw new notFoundElementException("Ticket with id " + id + " not found");
//	}
//	
//	public void removeTicketHistory(int index) {
//		history.remove(index);
//	}
//	
//	public void removeTicketHistory(String id) throws notFoundElementException{
//		Iterator <Ticket> it = history.iterator();
//		boolean eliminado = false;
//		while(it.hasNext()){
//			Ticket ticket = it.next();
//			if(ticket.getTicketId().equals(id)) {
//				it.remove();
//				eliminado = true;
//			}
//		}
//		
//		if(!eliminado) {
//			throw new notFoundElementException("The ticket with id " + id + " have not been found");
//		}
//	}
	
	public void addTicketCurrentEvents(Ticket ticket){
		currentEvents.add(ticket);
	}
	
	public Ticket getTicketCurrentEvents(int index) {
		return currentEvents.get(index);
	}
	
	public Ticket getTicketCurrentEvents(String id) throws notFoundElementException {
		Ticket ticket = null;
		for (int i = 0; i < currentEvents.size(); i++) {
			ticket = currentEvents.get(i);
			if(ticket.getTicketId().equals(id)) {
				return ticket;
			}
		}
		throw new notFoundElementException("Ticket with id " + id + " not found");
	}
	
	public void removeTicketCurrentEvents(int index) {
		currentEvents.remove(index);
	}
	
	public void removeTicketCurrentEvents(String id) throws notFoundElementException{
		Iterator <Ticket> it = currentEvents.iterator();
		boolean eliminado = false;
		while(it.hasNext()){
			Ticket ticket = it.next();
			if(ticket.getTicketId().equals(id)) {
				it.remove();
				eliminado = true;
			}
		}
		
		if(!eliminado) {
			throw new notFoundElementException("The ticket with id " + id + " have not been found");
		}
	}	
}
