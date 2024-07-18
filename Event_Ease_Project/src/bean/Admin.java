package bean;

import java.util.LinkedList;
import java.util.List;

import exceptions.notFoundElementException;

public class Admin extends Staff {

	private boolean validated = false;
	
	private List <EventManager> listaManagers;
	//private List <Cashier> listaCashiers;
	private String Companyld;
	private String IBAN;
	
	public Admin(String id, String password, String email, int tlf_number) {
		super(id, password, email, tlf_number);
		listaManagers = new LinkedList<>();
	}

	public void AddEM (EventManager e){
		listaManagers.add(e);
	}

	public void RemoveEM (EventManager e){
		listaManagers.remove(e);
	}
	
	public EventManager getEM(String id) throws notFoundElementException {
		EventManager em= null;
		for (int i = 0; i < listaManagers.size(); i++) {
			em = listaManagers.get(i);
			if(em.getId().equals(id)) {
				return em;
			}
		}
		throw new notFoundElementException("Event Manager with id " + id + " not found");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////  CHECK WHO CALLS THESE FUNCTIONS ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	public boolean BankTransfer (String to) {
		return false;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		
	}

	public String getCompanyld() {
		return Companyld;
	}

	public void setCompanyld(String companyld) {
		Companyld = companyld;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}
//	public void RemoveCashier () {
//	
//}
//
//public void AddCashier () {
//	
//}
}
