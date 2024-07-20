package bean;



public class Admin extends Staff {

	private boolean validated = false;
	
	//Hace falta  ?
	//private List <Cashier> listaCashiers;
	private int Companyld;
	private String IBAN;
	public Admin() {
		
	}
	public Admin(String id, String password, String email, int tlf_number) {
		super(id, password, email, tlf_number);
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

	public int getCompanyld() {
		return Companyld;
	}

	public void setCompanyld(int companyld) {
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
