package utils;

public class Utente {
	
	private String user, pass;

	public Utente(String user, String pass) {
		
		this.user = user;
		this.pass = pass;
		
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
