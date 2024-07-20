package bean;

import java.util.LinkedList;
import java.util.List;

import exceptions.notFoundElementException;

public abstract class Staff extends Profile{
	
	private List<Event> listaEventos;
	//private List<Event> historicoEventos;

	
	public Staff() {
		
	}
	public Staff(String id, String password, String email, int tlf_number) {
		super(id, password, email, tlf_number);
		listaEventos = new LinkedList<Event>();
		//historicoEventos = new LinkedList<Event>();
	}

	public Event getEvent (int i){
		return listaEventos.get(i);
	}
	public Event getEvent(String name) throws notFoundElementException {
		Event event= null;
		for (int i = 0; i < listaEventos.size(); i++) {
			event = listaEventos.get(i);
			if(event.getName().equals(name)) {
				return event;
			}
		}
		throw new notFoundElementException("Event  with id " + name+ " not found");
	}
//	public Event getEventfromHistory(String name) throws notFoundElementException {
//		Event event= null;
//		for (int i = 0; i < historicoEventos.size(); i++) {
//			event = listaEventos.get(i);
//			if(event.getName().equals(name)) {
//				return event;
//			}
//		}
//		throw new notFoundElementException("Event  with id " + name+ " not found");
//	}
	public void addEvent (Event e){
		listaEventos.add(e);
	}
//	public void addEventToHistory(Event e) {
//		historicoEventos.add(e);
//	}
	public void modifyEvent (Event e, Event newE){
		int i = listaEventos.indexOf(e);
		listaEventos.add(i, newE);
	}
	public void deleteEvent (Event e){
		listaEventos.remove(e);
	}
//	public List<Event> viewHistory (){
//		return historicoEventos;
//	}
	public List<Event> getListEvents (){
		return listaEventos;
	}
}
