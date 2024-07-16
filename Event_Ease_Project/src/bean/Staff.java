package bean;

import java.util.LinkedList;
import java.util.List;

public abstract class Staff extends Profile{
	
	private List<Event> listaEventos;
	private List<Event> historicoEventos;


	public Staff(String id, String password, String email, int tlf_number) {
		super(id, password, email, tlf_number);
		listaEventos = new LinkedList<Event>();
		historicoEventos = new LinkedList<Event>();
	}

	public Event GetEvent (int i){
		return listaEventos.get(i);
	}
	public void AddEvent (Event e){
		listaEventos.add(e);
	}
	public void ModifyEvent (Event e, Event newE){
		int i = listaEventos.indexOf(e);
		listaEventos.add(i, newE);
	}
	public void DeleteEvent (Event e){
		listaEventos.remove(e);
	}
	public List<Event> ViewHistory (){
		return historicoEventos;
	}
	public List<Event> GetListEvents (){
		return listaEventos;
	}
}
